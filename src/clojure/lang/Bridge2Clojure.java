package clojure.lang;

import java.io.IOException;
import java.util.Arrays;

import org.eclipse.imp.pdb.facts.IConstructor;
import org.eclipse.imp.pdb.facts.ISourceLocation;
import org.eclipse.imp.pdb.facts.IString;
import org.eclipse.imp.pdb.facts.IValueFactory;
import org.rascalmpl.interpreter.utils.RuntimeExceptionFactory;
import org.rascalmpl.values.ValueFactoryFactory;

import clojure.lang.RT;
import clojure.lang.UPTRCompiler;

public class Bridge2Clojure {

	private final IValueFactory vf;

	
	
	public Bridge2Clojure(IValueFactory vf) {
		try {
			RT.doInit();
		} catch (ClassNotFoundException e) {
			RuntimeExceptionFactory.javaException(e.getMessage(), null, Arrays.toString(e.getStackTrace()));
		} catch (IOException e) {
			RuntimeExceptionFactory.io(vf.string(e.getMessage()), null, Arrays.toString(e.getStackTrace()));
		}
		this.vf = vf;
	}
	
	public IConstructor loadForRascal(IString src, ISourceLocation loc) {
		System.err.println("Loading...");
		IConstructor pt = UPTRCompiler.loadForRascal(vf, src, loc);
		System.err.println("Done...");
		return pt;
	}
	
	public static void main(String args[]) {
		IValueFactory vf = ValueFactoryFactory.getValueFactory();
		Bridge2Clojure bridge = new Bridge2Clojure(vf);
		IConstructor pt = bridge.loadForRascal(vf.string("()"), vf.sourceLocation("/"));
		System.out.println(pt);
	}
	
	
}
