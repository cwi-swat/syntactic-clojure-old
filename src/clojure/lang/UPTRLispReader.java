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

import static org.rascalmpl.values.clojure.FormAdapter.getLineNumber;
import static org.rascalmpl.values.clojure.FormAdapter.getLiteralValue;
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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.imp.pdb.facts.IConstructor;
import org.eclipse.imp.pdb.facts.IList;
import org.eclipse.imp.pdb.facts.IListWriter;
import org.eclipse.imp.pdb.facts.IValue;
import org.eclipse.imp.pdb.facts.IValueFactory;
import org.eclipse.imp.pdb.facts.type.Type;
import org.eclipse.imp.pdb.facts.type.TypeFactory;
import org.rascalmpl.interpreter.result.ICallableValue;
import org.rascalmpl.interpreter.result.Result;
import org.rascalmpl.values.synclj.MetaGrammar;
import org.rascalmpl.values.uptr.TreeAdapter;

public class UPTRLispReader extends LispReader {

	private static final Keyword META_GRAMMAR = Keyword.intern("meta-grammar");
	private static final Object DISCARD = new Object();
	private final IValueFactory vf;
	private final TypeFactory tf = TypeFactory.getInstance();
	private final ICallableValue metaParser;
	private final ICallableValue objectParser;
	
	
	public UPTRLispReader(IValueFactory vf, ICallableValue metaParser, ICallableValue objectParser) {
		this.vf = vf;
		this.metaParser = metaParser;
		this.objectParser = objectParser;
	}
	
	// TODO: unreadable reader (?), eval reader, data readers, ctor reader, record
	
	// Result tuples.
	public static class Pair {
		public final IConstructor tree;
		public final Object obj;

		public Pair(IConstructor tree, Object obj) {
			this.tree = tree;
			this.obj = obj;
		}
	}
	
	public static class ListPair {
		public final IList trees;
		public final List<Object> objs;

		public ListPair(IList trees, List<Object> objs) {
			this.trees = trees;
			this.objs = objs;
		}
	}

	public Pair read(IConstructor tree) {
		try {
			if (isNumber(tree)) {
				return new Pair(tree, matchNumber(getLiteralValue(tree)));
			}
			if (isChar(tree)) {
				return new Pair(tree, matchCharacter(getLiteralValue(tree).substring(1)));
			}
			if (isString(tree)) {
				return new Pair(tree, readString(getLiteralValue(tree).substring(1)));
			}
			if (isRegexp(tree)) {
				return new Pair(tree, readRegexp(getLiteralValue(tree).substring(2)));
			}
			if (isMeta(tree)) {
				return readMeta(tree);
			}
			if (isSymbol(tree)) {
				return new Pair(tree, interpretToken(getLiteralValue(tree)));
			}
			if (isList(tree)) {
				return readList(tree, getLineNumber(tree));
			}
			if (isSet(tree)) {
				ListPair lp = readForms(TreeAdapter.getArgs(tree));
				tree = tree.set("args", lp.trees);
				return new Pair(tree, PersistentHashSet.createWithCheck(lp.objs));
			}
			if (isVector(tree)) {
				ListPair lp = readForms(TreeAdapter.getArgs(tree));
				tree = tree.set("args", lp.trees);
				return new Pair(tree, LazilyPersistentVector.create(lp.objs));
			}
			if (isMap(tree)) {
				return readMap(tree);
			}
			if (isQuote(tree)) {
				ListPair lp = readArgs(TreeAdapter.getArgs(tree));
				tree = tree.set("args", lp.trees);
				return new Pair(tree, RT.list(QUOTE, lp.objs.get(0)));
			}
			if (isDeref(tree)) {
				ListPair lp = readArgs(TreeAdapter.getArgs(tree));
				tree = tree.set("args", lp.trees);
				return new Pair(tree, RT.list(DEREF, lp.objs.get(0)));
			}
			if (isFn(tree)) {
				return readFn(tree);
			}
			if (isArg(tree)) {
				return new Pair(tree, readArg(getLiteralValue(tree)));
			}
			if (isVar(tree)) {
				ListPair lp = readForms(TreeAdapter.getArgs(tree));
				tree = tree.set("args", lp.trees);
				return new Pair(tree, RT.list(THE_VAR, lp.objs.get(0)));
			}
			if (isDiscard(tree)) {
				return new Pair(tree, DISCARD);
			}
			if (isQQuote(tree)) {
				return readQuasi(tree);
			}
			if (isUnquote(tree)) {
				ListPair lp = readArgs(TreeAdapter.getArgs(tree));
				tree = tree.set("args", lp.trees);
				return new Pair(tree, RT.list(UNQUOTE, lp.objs.get(0)));
			}
			if (isUnquotes(tree)) {
				ListPair lp = readArgs(TreeAdapter.getArgs(tree));
				tree = tree.set("args", lp.trees);
				return new Pair(tree, RT.list(UNQUOTE_SPLICING, lp.objs.get(0)));
			}
			throw new RuntimeException("Cannot read tree: " + getLiteralValue(tree));
		} catch (Exception e) {
			throw new ReaderException(getLineNumber(tree), e);
		}
	}

	private Pair readQuasi(IConstructor tree) {
		try {
			Var.pushThreadBindings(RT.map(GENSYM_ENV, PersistentHashMap.EMPTY));
			ListPair lp = readArgs(TreeAdapter.getArgs(tree));
			tree = tree.set("args", lp.trees);
			return new Pair(tree, SyntaxQuoteReader.syntaxQuote(lp.objs.get(0)));
		}
		finally {
			Var.popThreadBindings();
		}
	}

	private Object readArg(String token) {
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

	private Pair readFn(IConstructor tree) {
		if(ARG_ENV.deref() != null) {
			throw new IllegalStateException("Nested #()s are not allowed");
		}
		try {
			Var.pushThreadBindings(RT.map(ARG_ENV, PersistentTreeMap.EMPTY));
			ListPair lp = readForms(TreeAdapter.getArgs(tree));

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
			tree = tree.set("args", lp.trees);
			return new Pair(tree, RT.list(Compiler.FN, args, PersistentList.create(lp.objs)));
		}
		finally {
			Var.popThreadBindings();
		}
	}

	private Pair readMap(IConstructor tree) {
		ListPair pl = readForms(TreeAdapter.getArgs(tree));
		tree = tree.set("args", pl.trees);
		if ((pl.objs.size() & 1) == 1) {
			throw Util.runtimeException("Map literal must contain an even number of forms");
		}
		return new Pair(tree, RT.map(pl.objs.toArray()));
	}

	private Pair readList(IConstructor tree, int line) {
		if (TreeAdapter.getASTArgs(tree).isEmpty()) {
			return new Pair(tree, PersistentList.EMPTY);
		}
		IList args = TreeAdapter.getArgs(tree);
		ListPair lp = readForms(args);
		IPersistentList seq = PersistentList.create(lp.objs);
		if (seq.peek() instanceof Symbol) {
			Object grammar = getGrammar(seq.peek());
			if (grammar != null) {
				StringBuilder sb = new StringBuilder();
				// here we need full args, not just AST args.
				// start at 4 and stop early to skip name and pre/post layout
				// "(" _ sym _ .... _  ")"
				//  0  1  2  3 4   n-2 n-1
				int len = args.length();
				for (int i = 4; i < len - 2; i++) {
					sb.append(TreeAdapter.yield((IConstructor) args.get(i)));
				}
				String src = sb.toString();
				
				// this is the tree that should be patched up in the original tree.
				IConstructor pt = parseUsingGrammar(grammar, src);
				Pair lowered = lower(pt);
				IListWriter newArgs = vf.listWriter();
				
				// Reconstruct "(" _ sym _
				for (int i = 0; i < 4; i++) {
					newArgs.append(args.get(i));
				}
				// add the newly parsed AST.
				newArgs.append(lowered.tree);
				
				// Reconstruct _ ")"
				for (int i = len - 2; i < len; i++) {
					newArgs.append(args.get(i));
				}
				
				tree = tree.set("args", newArgs.done());
				seq = (IPersistentList) RT.list(seq.peek(), lowered.obj);
			}
			else {
				tree = tree.set("args", lp.trees);
			}
		}
		IObj s = (IObj) seq;
		return new Pair(tree, s.withMeta(RT.map(RT.LINE_KEY, line)));
	}

	private IConstructor parseUsingGrammar(Object grammar, String string) {
		// TODO: pass current namespace to parser functions.
		if (grammar == META_GRAMMAR) {
			Result<IValue> result = metaParser.call(new Type[] {tf.stringType()}, 
					new IValue[] {vf.string(string)});
			return (IConstructor) result.getValue();
		}
		else {
			IConstructor ast = (IConstructor) liftGrammar(grammar);
			Result<IValue> result = objectParser.call(new Type[] {MetaGrammar.MetaGrammar, tf.stringType()}, 
					new IValue[] {ast, vf.string(string)});
			return (IConstructor) result.getValue();
		}
	}

	private IValue liftGrammar(Object node) {
		// TODO: deal with namespaces properly.
		if (node instanceof IPersistentList) {
			ISeq seq = ((IPersistentList)node).seq();
			String name = ((Symbol)seq.first()).getName();
			IList args = liftSeq(seq.next());
			return vf.constructor(MetaGrammar.getTypeForName(name), args);
		}
		if (node instanceof IPersistentVector) {
			return liftSeq(((IPersistentVector)node).seq());
		}
		if (node instanceof Keyword) {
			return vf.constructor(MetaGrammar.getTypeForName(((Keyword)node).getName()));
		}
		if (node instanceof Symbol) {
			return vf.constructor(MetaGrammar.getTypeForName("nonTerminal"), vf.string(((Symbol)node).getName()));
		}
		if (node instanceof String) {
			return vf.constructor(MetaGrammar.getTypeForName("literal"), vf.string((String) node));
		}
		throw new AssertionError("cannot lift Grammar node: " + node);
	}

	private ListPair lowerArgs(IList args) {
		List<Object> elts = new ArrayList<Object>();
		IListWriter newArgs = vf.listWriter();
		for (int i = 0; i < args.length(); i++) {
			IConstructor kid = (IConstructor) args.get(i);
			if (!TreeAdapter.isLiteral(kid) && !TreeAdapter.isCILiteral(kid)) {
				Pair p = lower(kid);
				elts.add(p.obj);
				newArgs.append(p.tree);
			}
			else {
				newArgs.append(kid);
			}
			i++;
			newArgs.append(args.get(i)); // layout
		}			
		return new ListPair(newArgs.done(), elts);
	}
	
	private Pair lower(IConstructor tree) {
		if (TreeAdapter.isList(tree) || TreeAdapter.isOpt(tree)) {
			// make vector			
			ListPair lp = lowerArgs(TreeAdapter.getArgs(tree));
			tree = tree.set("args", lp.trees);
			return new Pair(tree, RT.vector(lp.objs));
		}
		if (isClojureTree(tree)) {
			// NB: we're safe here, despite the lexical tokens are not wrapped/injected
			// in Forms. Tokens are unparsed and read according to Clojure.
			// "forms" are wrapped as Form, so getASTargs and friends work as expected.
			return read(tree);
		}
		if (TreeAdapter.isAppl(tree)) {
			// an appl with a non-clojure label
			ListPair lp = lowerArgs(TreeAdapter.getArgs(tree));
			String name = TreeAdapter.getConstructorName(tree);
			tree = tree.set("args", lp.trees);
			return new Pair(tree, RT.cons(name, PersistentList.create(lp.objs)));
		}
		throw new AssertionError("Tree is not an appl: " + tree);
	}
	
	private final static List<String> CLOJURE_LABELS = Arrays.asList("form", 
			"integer", "string", "symbol", "char", "float", "number", "regexp");
	
	private boolean isClojureTree(IConstructor tree) {
		return CLOJURE_LABELS.contains(TreeAdapter.getConstructorName(tree));
	}

	private IList liftSeq(ISeq seq) {
		IListWriter w = vf.listWriter();
		while (seq != null) {
			w.append(liftGrammar(seq.first()));
			seq = seq.next();
		}
		return w.done();
	}
	
	private Object getGrammar(Object op) {
		Var var = Compiler.isMacro(op);
		if (var != null) {
			return var.meta().valAt(Keyword.intern("grammar")); 
		}
		return null;
	}

	private ListPair readArgs(IList list) {
		List<Object> jlist = new ArrayList<Object>();
        IListWriter newList = vf.listWriter();

        for (int i = 0; i < list.length(); i++) {
                IConstructor kid = (IConstructor) list.get(i);
                if (!TreeAdapter.isLiteral(kid) && !TreeAdapter.isCILiteral(kid)) {
                        Pair p = read(kid);
                        if (p.obj != DISCARD) {
                                jlist.add(p.obj);
                        }
                        newList.append(p.tree);
                }
                else {
                        newList.append(kid);
                }
                if (i < list.length() - 2) {
                	i++;
                	newList.append(list.get(i)); // layout
                }
        }
        return new ListPair(newList.done(), jlist);
	}
	
	private ListPair readForms(IList list) {
		List<Object> jlist = new ArrayList<Object>();
		IListWriter newList = vf.listWriter();
		
		for (int i = 0; i < list.length(); i++) {
			IConstructor kid = (IConstructor) list.get(i);
			if (TreeAdapter.isList(kid)) {
				// Form*
				IListWriter newKidArgs = vf.listWriter();
				IList kidArgs = TreeAdapter.getArgs(kid);
				for (int j = 0; j < kidArgs.length(); j++) {
					IConstructor kidArg = (IConstructor)kidArgs.get(j);
					if (!TreeAdapter.isLiteral(kidArg) && !TreeAdapter.isCILiteral(kidArg)) {
						Pair p = read(kidArg);
						if (p.obj != DISCARD) {
							jlist.add(p.obj);
						}
						newKidArgs.append(p.tree);
					}
					else {
						newKidArgs.append(kidArg);
					}
					if (j < kidArgs.length() - 2) { // layout never at end
						j++;
						newKidArgs.append(kidArgs.get(j));
					}
				}
				kid = kid.set("args", newKidArgs.done());
				newList.append(kid);
			}
			else {
				newList.append(kid);
			}
			if (i < list.length() - 2) {
				i++;
				newList.append(list.get(i)); // layout
			}
		}
		return new ListPair(newList.done(), jlist);
	}

	private Pair readMeta(IConstructor tree) {
		IList args = TreeAdapter.getArgs(tree);
		// ^ _ Form _ Form
		IConstructor metaTree = (IConstructor) args.get(2);
		IConstructor argTree = (IConstructor) args.get(4);
		
		Pair p = read(metaTree);
		Object meta = p.obj;
		
		
		if (meta instanceof Symbol || meta instanceof String) {
			meta = RT.map(RT.TAG_KEY, meta);
		} else if (meta instanceof Keyword) {
			meta = RT.map(meta, RT.T);
		} else if (!(meta instanceof IPersistentMap)) {
			throw new IllegalArgumentException(
					"Metadata must be Symbol,Keyword,String or Map");
		}

		Pair argP = read(argTree);
		Object o = argP.obj;

		
		IListWriter newArgs = vf.listWriter();
		for (int i = 0; i < args.length(); i++) {
			if (i == 2) {
				newArgs.append(p.tree);
			}
			else if (i == 4) {
				newArgs.append(argP.tree);
			}
			else {
				newArgs.append(args.get(i));
			}
		}
				tree = tree.set("args", newArgs.done());

		
		if (o instanceof IMeta) {
			int line = getLineNumber(argTree);
			if (line != -1 && o instanceof ISeq) {
				meta = ((IPersistentMap) meta).assoc(RT.LINE_KEY, line);
			}
			if (o instanceof IReference) {
				((IReference) o).resetMeta((IPersistentMap) meta);
				return new Pair(tree, o);
			}
			Object ometa = RT.meta(o);
			for (ISeq s = RT.seq(meta); s != null; s = s.next()) {
				IMapEntry kv = (IMapEntry) s.first();
				ometa = RT.assoc(ometa, kv.getKey(), kv.getValue());
			}
			return new Pair(tree, ((IObj) o).withMeta((IPersistentMap) ometa));
		} else {
			throw new IllegalArgumentException(
					"Metadata can only be applied to IMetas");
		}
	}

	private Object readRegexp(String str) {
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

	private Object readString(String str) {
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

	private Object matchCharacter(String token) {
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

	private int readUnicodeChar(String token, int offset, int length,
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

	private Object interpretToken(String s) {
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

	private Object matchSymbol(String s) {
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

	private Object matchNumber(String s) {
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
	public class ReaderException extends RuntimeException {
		final int line;

		public ReaderException(int line, Throwable cause) {
			super(cause);
			this.line = line;
		}
	}

}
