package clojure.lang;

/**
 *   Copyright (c) Rich Hickey. All rights reserved.
 *   The use and distribution terms for this software are covered by the
 *   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
 *   which can be found in the file epl-v10.html at the root of this distribution.
 *   By using this software in any fashion, you are agreeing to be bound by
 * 	 the terms of this license.
 *   You must not remove this notice, or any other, from this software.
 **/

import static org.rascalmpl.values.clojure.FormAdapter.getArgumentForm;
import static org.rascalmpl.values.clojure.FormAdapter.getArgumentForms;
import static org.rascalmpl.values.clojure.FormAdapter.getLineNumber;
import static org.rascalmpl.values.clojure.FormAdapter.getLiteralValue;
import static org.rascalmpl.values.clojure.FormAdapter.getMetaArg;
import static org.rascalmpl.values.clojure.FormAdapter.getMetaMeta;
import static org.rascalmpl.values.clojure.FormAdapter.isArg;
import static org.rascalmpl.values.clojure.FormAdapter.isChar;
import static org.rascalmpl.values.clojure.FormAdapter.isDeref;
import static org.rascalmpl.values.clojure.FormAdapter.isDiscard;
import static org.rascalmpl.values.clojure.FormAdapter.isFn;
import static org.rascalmpl.values.clojure.FormAdapter.isList;
import static org.rascalmpl.values.clojure.FormAdapter.isMap;
import static org.rascalmpl.values.clojure.FormAdapter.isMeta;
import static org.rascalmpl.values.clojure.FormAdapter.isNumber;
import static org.rascalmpl.values.clojure.FormAdapter.isQQuote;
import static org.rascalmpl.values.clojure.FormAdapter.isQuote;
import static org.rascalmpl.values.clojure.FormAdapter.isRegexp;
import static org.rascalmpl.values.clojure.FormAdapter.isSet;
import static org.rascalmpl.values.clojure.FormAdapter.isString;
import static org.rascalmpl.values.clojure.FormAdapter.isSymbol;
import static org.rascalmpl.values.clojure.FormAdapter.isUnquotes;
import static org.rascalmpl.values.clojure.FormAdapter.isVar;
import static org.rascalmpl.values.clojure.FormAdapter.isVector;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.imp.pdb.facts.IConstructor;
import org.eclipse.imp.pdb.facts.IList;
import org.eclipse.imp.pdb.facts.IValue;
import org.eclipse.imp.pdb.facts.exceptions.FactTypeUseException;
import org.rascalmpl.values.uptr.TreeAdapter;

public class UPTRLispReader extends LispReader {

	private static final Object DISCARD = new Object();
	
	// TODO: unreadable reader (?), eval reader, data readers, ctor reader, record

	static public Object read(IConstructor tree) {
		try {
			if (isNumber(tree)) {
				return matchNumber(getLiteralValue(tree));
			}
			if (isChar(tree)) {
				return matchCharacter(getLiteralValue(tree).substring(1));
			}
			if (isString(tree)) {
				return readString(getLiteralValue(tree).substring(1));
			}
			if (isRegexp(tree)) {
				return readRegexp(getLiteralValue(tree).substring(2));
			}
			if (isMeta(tree)) {
				return readMeta(getMetaMeta(tree), getMetaArg(tree));
			}
			if (isSymbol(tree)) {
				return interpretToken(getLiteralValue(tree));
			}
			if (isList(tree)) {
				//getArgumentForms(tree)
				return readList(TreeAdapter.getArgs(tree), getArgumentForms(tree), getLineNumber(tree));
			}
			if (isSet(tree)) {
				return PersistentHashSet.createWithCheck(readForms(getArgumentForms(tree)));
			}
			if (isVector(tree)) {
				return LazilyPersistentVector.create(readForms(getArgumentForms(tree)));
			}
			if (isMap(tree)) {
				return readMap(getArgumentForms(tree));
			}
			if (isQuote(tree)) {
				return RT.list(QUOTE, read(getArgumentForm(tree)));
			}
			if (isDeref(tree)) {
				return RT.list(DEREF, read(getArgumentForm(tree)));
			}
			if (isFn(tree)) {
				return readFn(getArgumentForms(tree));
			}
			if (isArg(tree)) {
				return readArg(getLiteralValue(tree));
			}
			if (isVar(tree)) {
				return RT.list(THE_VAR, read(getArgumentForm(tree)));
			}
			if (isDiscard(tree)) {
				return DISCARD;
			}
			if (isQQuote(tree)) {
				return readQuasi(getArgumentForm(tree));
			}
			if (isUnquote(tree)) {
				return RT.list(UNQUOTE, read(getArgumentForm(tree)));
			}
			if (isUnquotes(tree)) {
				return RT.list(UNQUOTE_SPLICING, read(getArgumentForm(tree)));
			}
			throw new RuntimeException("Cannot read tree: " + getLiteralValue(tree));
		} catch (Exception e) {
			throw new ReaderException(getLineNumber(tree), e);
		}
	}

	private static Object readQuasi(IConstructor arg) {
		try {
			Var.pushThreadBindings(RT.map(GENSYM_ENV, PersistentHashMap.EMPTY));
			return SyntaxQuoteReader.syntaxQuote(read(arg));
		}
		finally {
			Var.popThreadBindings();
		}
	}

	private static Object readArg(String token) {
		if (ARG_ENV.deref() == null) {
			return interpretToken(token);
		}
		if ("%".equals(token)) {
			return registerArg(1);
		}
		if ("%&".equals(token)) {
			return registerArg(-1);
		}
		if (token.startsWith("%")) {
			String num = token.substring(1);
			if (num.matches("^[1-9][0-9]*$")) {
				return registerArg(Integer.parseInt(num));
			}
		}
		throw new IllegalStateException("arg literal must be %, %& or %integer");
	}

	private static Object readFn(IList argumentForms) {
		if(ARG_ENV.deref() != null) {
			throw new IllegalStateException("Nested #()s are not allowed");
		}
		try {
			Var.pushThreadBindings(RT.map(ARG_ENV, PersistentTreeMap.EMPTY));
			List<Object> forms = readForms(argumentForms);

			PersistentVector args = PersistentVector.EMPTY;
			PersistentTreeMap argsyms = (PersistentTreeMap) ARG_ENV.deref();
			ISeq rargs = argsyms.rseq();
			if (rargs != null) {
				@SuppressWarnings("rawtypes")
				int higharg = (Integer) ((Map.Entry) rargs.first()).getKey();
				if (higharg > 0) {
					for (int i = 1; i <= higharg; ++i) {
						Object sym = argsyms.valAt(i);
						if(sym == null) {
							sym = garg(i);
						}
						args = args.cons(sym);
					}
				}
				Object restsym = argsyms.valAt(-1);
				if(restsym != null) {
					args = args.cons(Compiler._AMP_);
					args = args.cons(restsym);
				}
			}
			return RT.list(Compiler.FN, args, PersistentList.create(forms));
		}
		finally {
			Var.popThreadBindings();
		}
	}

	private static Object readMap(IList argumentForms) {
		List<Object> pairs = readForms(argumentForms);
		if ((pairs.size() & 1) == 1) {
			// deviation from standard clojure
			pairs.add(null);
		}
		return RT.map(pairs);
	}

	private static Object readList(IList fullArgs, IList list, int line) {
		if (list.isEmpty()) {
			return PersistentList.EMPTY;
		}
		IPersistentList seq = PersistentList.create(readForms(list));
		if (seq.peek() instanceof Symbol) {
			Var var = Compiler.isMacro(seq.peek());
			if (var != null && var.meta().valAt(Keyword.intern("parsing")) == RT.T) {
				StringBuilder sb = new StringBuilder();
				// here we need full args, not just AST args.
				// start at 4 and stop early to skip name and pre/post layout
				// "(" _ sym _ .... _ ")"
				//  0  1  2  3 4    n-2   n-1
				for (int i = 4; i < fullArgs.length() - 3; i++) {
					sb.append(TreeAdapter.yield((IConstructor) list.get(i)));
				}
				seq = (IPersistentList) RT.list(seq.peek(), sb.toString());
			}
		}
		IObj s = (IObj) seq;
		return s.withMeta(RT.map(RT.LINE_KEY, line));
	}

	private static List<Object> readForms(IList list) {
		List<Object> jlist = new ArrayList<Object>();
		for (IValue elt : list) {
			Object x = read((IConstructor) elt);
			if (x != DISCARD) {
				jlist.add(x);
			}
		}
		return jlist;
	}

	private static Object readMeta(IConstructor metaTree, IConstructor argTree) {
		Object meta = read(metaTree);
		if (meta instanceof Symbol || meta instanceof String) {
			meta = RT.map(RT.TAG_KEY, meta);
		} else if (meta instanceof Keyword) {
			meta = RT.map(meta, RT.T);
		} else if (!(meta instanceof IPersistentMap)) {
			throw new IllegalArgumentException(
					"Metadata must be Symbol,Keyword,String or Map");
		}

		Object o = read(argTree);
		if (o instanceof IMeta) {
			int line = getLineNumber(argTree);
			if (line != -1 && o instanceof ISeq) {
				meta = ((IPersistentMap) meta).assoc(RT.LINE_KEY, line);
			}
			if (o instanceof IReference) {
				((IReference) o).resetMeta((IPersistentMap) meta);
				return o;
			}
			Object ometa = RT.meta(o);
			for (ISeq s = RT.seq(meta); s != null; s = s.next()) {
				IMapEntry kv = (IMapEntry) s.first();
				ometa = RT.assoc(ometa, kv.getKey(), kv.getValue());
			}
			return ((IObj) o).withMeta((IPersistentMap) ometa);
		} else {
			throw new IllegalArgumentException(
					"Metadata can only be applied to IMetas");
		}
	}

	private static Object readRegexp(String str) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (int ch = str.charAt(i); ch != '"'; ch = str.charAt(++i)) {
			sb.append((char) ch);
			if (ch == '\\') // escape
			{
				ch = str.charAt(++i);
				sb.append((char) ch);
			}
		}
		return Pattern.compile(sb.toString());
	}

	private static Object readString(String str) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (int ch = str.charAt(i); ch != '"'; ch = str.charAt(++i)) {
			if (ch == '\\') // escape
			{
				ch = str.charAt(++i);
				if (ch == -1)
					throw Util.runtimeException("EOF while reading string");
				switch (ch) {
				case 't':
					ch = '\t';
					break;
				case 'r':
					ch = '\r';
					break;
				case 'n':
					ch = '\n';
					break;
				case '\\':
					break;
				case '"':
					break;
				case 'b':
					ch = '\b';
					break;
				case 'f':
					ch = '\f';
					break;
				case 'u': {
					ch = str.charAt(++i);
					if (Character.digit(ch, 16) == -1) {
						throw Util
								.runtimeException("Invalid unicode escape: \\u"
										+ (char) ch);
					}
					ch = readUnicodeChar(str.substring(i, i + 4), 0, 4, 16);
					i += 4;
					break;
				}
				default: {
					if (Character.isDigit(ch)) {
						ch = readUnicodeChar(str.substring(i, i + 3), 0, 3, 8);
						i += 3;
						if (ch > 0377) {
							throw Util
									.runtimeException("Octal escape sequence must be in range [0, 377].");
						}
					} else {
						throw Util
								.runtimeException("Unsupported escape character: \\"
										+ (char) ch);
					}
				}
				}
				sb.append((char) ch);
			}
		}
		return sb.toString();
	}

	private static Object matchCharacter(String token) {
		if (token.length() == 1)
			return Character.valueOf(token.charAt(0));
		else if (token.equals("newline"))
			return '\n';
		else if (token.equals("space"))
			return ' ';
		else if (token.equals("tab"))
			return '\t';
		else if (token.equals("backspace"))
			return '\b';
		else if (token.equals("formfeed"))
			return '\f';
		else if (token.equals("return"))
			return '\r';
		else if (token.startsWith("u")) {
			char c = (char) readUnicodeChar(token, 1, 4, 16);
			if (c >= '\uD800' && c <= '\uDFFF') // surrogate code unit?
				throw Util.runtimeException("Invalid character constant: \\u"
						+ Integer.toString(c, 16));
			return c;
		} else if (token.startsWith("o")) {
			int len = token.length() - 1;
			if (len > 3)
				throw Util
						.runtimeException("Invalid octal escape sequence length: "
								+ len);
			int uc = readUnicodeChar(token, 1, len, 8);
			if (uc > 0377)
				throw Util
						.runtimeException("Octal escape sequence must be in range [0, 377].");
			return (char) uc;
		}
		throw Util.runtimeException("Unsupported character: \\" + token);
	}

	static private int readUnicodeChar(String token, int offset, int length,
			int base) {
		if (token.length() != offset + length)
			throw new IllegalArgumentException("Invalid unicode character: \\"
					+ token);
		int uc = 0;
		for (int i = offset; i < offset + length; ++i) {
			int d = Character.digit(token.charAt(i), base);
			if (d == -1)
				throw new IllegalArgumentException("Invalid digit: "
						+ token.charAt(i));
			uc = uc * base + d;
		}
		return (char) uc;
	}

	static private Object interpretToken(String s) {
		if (s.equals("nil")) {
			return null;
		} else if (s.equals("true")) {
			return RT.T;
		} else if (s.equals("false")) {
			return RT.F;
		} else if (s.equals("/")) {
			return SLASH;
		} else if (s.equals("clojure.core//")) {
			return CLOJURE_SLASH;
		}
		Object ret = null;

		ret = matchSymbol(s);
		if (ret != null)
			return ret;

		throw Util.runtimeException("Invalid token: " + s);
	}

	private static Object matchSymbol(String s) {
		Matcher m = symbolPat.matcher(s);
		if (m.matches()) {
			String ns = m.group(1);
			String name = m.group(2);
			if (ns != null && ns.endsWith(":/") || name.endsWith(":")
					|| s.indexOf("::", 1) != -1)
				return null;
			if (s.startsWith("::")) {
				Symbol ks = Symbol.intern(s.substring(2));
				Namespace kns;
				if (ks.ns != null)
					kns = Compiler.namespaceFor(ks);
				else
					kns = Compiler.currentNS();
				// auto-resolving keyword
				if (kns != null)
					return Keyword.intern(kns.name.name, ks.name);
				else
					return null;
			}
			boolean isKeyword = s.charAt(0) == ':';
			Symbol sym = Symbol.intern(s.substring(isKeyword ? 1 : 0));
			if (isKeyword)
				return Keyword.intern(sym);
			return sym;
		}
		return null;
	}

	private static Object matchNumber(String s) {
		Matcher m = intPat.matcher(s);
		if (m.matches()) {
			if (m.group(2) != null) {
				if (m.group(8) != null)
					return BigInt.ZERO;
				return Numbers.num(0);
			}
			boolean negate = (m.group(1).equals("-"));
			String n;
			int radix = 10;
			if ((n = m.group(3)) != null)
				radix = 10;
			else if ((n = m.group(4)) != null)
				radix = 16;
			else if ((n = m.group(5)) != null)
				radix = 8;
			else if ((n = m.group(7)) != null)
				radix = Integer.parseInt(m.group(6));
			if (n == null)
				return null;
			BigInteger bn = new BigInteger(n, radix);
			if (negate)
				bn = bn.negate();
			if (m.group(8) != null)
				return BigInt.fromBigInteger(bn);
			return bn.bitLength() < 64 ? Numbers.num(bn.longValue()) : BigInt
					.fromBigInteger(bn);
		}
		m = floatPat.matcher(s);
		if (m.matches()) {
			if (m.group(4) != null)
				return new BigDecimal(m.group(1));
			return Double.parseDouble(s);
		}
		m = ratioPat.matcher(s);
		if (m.matches()) {
			return Numbers.divide(Numbers.reduceBigInt(BigInt
					.fromBigInteger(new BigInteger(m.group(1)))), Numbers
					.reduceBigInt(BigInt.fromBigInteger(new BigInteger(m
							.group(2)))));
		}
		return null;
	}

	@SuppressWarnings("serial")
	public static class ReaderException extends RuntimeException {
		final int line;

		public ReaderException(int line, Throwable cause) {
			super(cause);
			this.line = line;
		}
	}

}
