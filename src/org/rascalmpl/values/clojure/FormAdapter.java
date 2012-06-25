package org.rascalmpl.values.clojure;

import static org.rascalmpl.values.uptr.TreeAdapter.getASTArgs;
import static org.rascalmpl.values.uptr.TreeAdapter.unparse;

import java.io.IOException;
import java.io.StringWriter;

import org.eclipse.imp.pdb.facts.IConstructor;
import org.eclipse.imp.pdb.facts.IList;
import org.eclipse.imp.pdb.facts.exceptions.FactTypeUseException;
import org.rascalmpl.values.uptr.TreeAdapter;


public class FormAdapter {
	
	public static IConstructor getArgumentForm(IConstructor tree) {
		if (isVar(tree) || isDeref(tree) || isQuote(tree) || isUnquote(tree) || isUnquotes(tree) || isQQuote(tree) || isDiscard(tree)) {
			IList args = getASTArgs(tree);
			return (IConstructor) args.get(0);
		}
		throw new AssertionError("No arg for " + TreeAdapter.getConstructorName(tree));
	}
	
	public static int getLineNumber(IConstructor tree) {
		return TreeAdapter.getLocation(tree).getBeginLine();
	}

	public static IList getArgumentForms(IConstructor tree) {
		if (isList(tree) || isVector(tree) || isMap(tree) || isSet(tree) || isFn(tree)) {
			return getASTArgs((IConstructor)getASTArgs(tree).get(0));
		}
		throw new AssertionError("No args for " + TreeAdapter.getConstructorName(tree));
	}
	
	public static boolean isMeta(IConstructor tree) {
		return "meta".equals(TreeAdapter.getConstructorName(tree));
	}
	
	public static IConstructor getMetaMeta(IConstructor tree) {
		return (IConstructor) getASTArgs(tree).get(0);
	}
	
	public static IConstructor getMetaArg(IConstructor tree) {
		return (IConstructor) getASTArgs(tree).get(1);
	}
	
	// string: String
	public static boolean isString(IConstructor tree) {
		return "string".equals(TreeAdapter.getConstructorName(tree));
	}
	
	public static String getLiteralValue(IConstructor tree) {
		StringWriter w = new StringWriter();
		try {
			unparse(tree, w);
		} catch (FactTypeUseException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return w.toString();
	}

	public static boolean isRegexp(IConstructor tree) {
		return "regexp".equals(TreeAdapter.getConstructorName(tree));
	}
	
	public static boolean isChar(IConstructor tree) {
		return "char".equals(TreeAdapter.getConstructorName(tree));
	}
	
	
	public static boolean isNumber(IConstructor tree) {
		return "number".equals(TreeAdapter.getConstructorName(tree));
	}

	public static boolean isArg(IConstructor tree) {
		return "arg".equals(TreeAdapter.getConstructorName(tree));
	}
	
	public static boolean isSymbol(IConstructor tree) {
		return "symbol".equals(TreeAdapter.getConstructorName(tree));
	}
	
	public static boolean isList(IConstructor tree) {
		return "list".equals(TreeAdapter.getConstructorName(tree));
	}
	
	public static boolean isVector(IConstructor tree) {
		return "vector".equals(TreeAdapter.getConstructorName(tree));
	}
	
	public static boolean isMap(IConstructor tree) {
		return "map".equals(TreeAdapter.getConstructorName(tree));
	}
	
	public static boolean isSet(IConstructor tree) {
		return "set".equals(TreeAdapter.getConstructorName(tree));
	}
	
	public static boolean isFn(IConstructor tree) {
		return "fn".equals(TreeAdapter.getConstructorName(tree));
	}
	
	public static boolean isVar(IConstructor tree) {
		return "var".equals(TreeAdapter.getConstructorName(tree));
	}
	
	public static boolean isDeref(IConstructor tree) {
		return "deref".equals(TreeAdapter.getConstructorName(tree));
	}
	
	public static boolean isUnquote(IConstructor tree) {
		return "unquote".equals(TreeAdapter.getConstructorName(tree));
	}
	
	public static boolean isUnquotes(IConstructor tree) {
		return "unquotes".equals(TreeAdapter.getConstructorName(tree));
	}
	
	public static boolean isQuote(IConstructor tree) {
		return "quote".equals(TreeAdapter.getConstructorName(tree));
	}
	
	public static boolean isQQuote(IConstructor tree) {
		return "qquote".equals(TreeAdapter.getConstructorName(tree));
	}
	
	public static boolean isDiscard(IConstructor tree) {
		return "discard".equals(TreeAdapter.getConstructorName(tree));
	}
	

}
