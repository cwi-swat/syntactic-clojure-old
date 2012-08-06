package clojure.lang;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.imp.pdb.facts.IConstructor;
import org.eclipse.imp.pdb.facts.INode;
import org.eclipse.imp.pdb.facts.ISet;
import org.eclipse.imp.pdb.facts.ISourceLocation;
import org.eclipse.imp.pdb.facts.IString;
import org.eclipse.imp.pdb.facts.IValueFactory;
import org.rascalmpl.interpreter.Evaluator;
import org.rascalmpl.interpreter.IRascalMonitor;
import org.rascalmpl.interpreter.asserts.ImplementationError;
import org.rascalmpl.interpreter.control_exceptions.Throw;
import org.rascalmpl.interpreter.env.GlobalEnvironment;
import org.rascalmpl.interpreter.env.ModuleEnvironment;
import org.rascalmpl.interpreter.utils.JavaBridge;
import org.rascalmpl.parser.gtd.IGTD;
import org.rascalmpl.parser.gtd.result.action.IActionExecutor;
import org.rascalmpl.parser.gtd.result.out.DefaultNodeFlattener;
import org.rascalmpl.parser.uptr.UPTRNodeFactory;

public class Bridge2Rascal {
	private Evaluator evaluator;
	private JavaBridge bridge;
	private final IString PKG;
	private final IValueFactory vf;
	private final Map<IConstructor, Class<IGTD<IConstructor,IConstructor,ISourceLocation>>> cache;

	public Bridge2Rascal(IValueFactory values) {
		PKG = values.string("lang.synclj.object.parsers");
		cache = new HashMap<IConstructor, Class<IGTD<IConstructor,IConstructor,ISourceLocation>>>();
		vf = values;
		GlobalEnvironment heap = new GlobalEnvironment();
		ModuleEnvironment scope = new ModuleEnvironment(
				"___parsergenerator_synclj___", heap);
		PrintWriter out = new PrintWriter(System.out);
		this.evaluator = new Evaluator(values, out, out, scope, heap);
		this.bridge = new JavaBridge(evaluator.getClassLoaders(), values);
		IRascalMonitor monitor = this.evaluator;
		monitor.startJob("Loading parser generator", 100, 139);
		// TODO: fix this; should be generically usable. Not just from this project.
		String wd = System.getProperty("user.dir");
		if (!wd.endsWith("syntactic-clojure")) {
			// If running from eclipse rascal, wd is the startup dir of eclipse
			// we, for now (:-S), assume that eclipse was started one dir up
			// from the workspace where our project resides. UGH!
			wd = wd + "/workspace/syntactic-clojure";
		}
		evaluator.addRascalSearchPath(URI.create("file://" + wd + "/src"));
		try {
			evaluator.doImport(monitor, "lang::rascal::grammar::ParserGenerator");
			evaluator.doImport(monitor, "lang::synclj::meta::NodeToGrammar");
		} catch (Throwable e) {
			throw new ImplementationError(
					"Exception while loading parser generator: "
							+ e.getMessage(), e);
		} finally {
			monitor.endJob(true);
		}
	}
	
	public IConstructor parse(INode grammar, String ns, String key, String src, ISourceLocation loc) {
		IConstructor rascalGrammar = (IConstructor) evaluator.call("node2Grammar", vf.string(ns), vf.string(key), grammar);
		IString start = (IString) ((IConstructor)((ISet)rascalGrammar.get(0)).iterator().next()).get(0);
		return parse(rascalGrammar, start.getValue(), src, loc);
	}
	

	private IConstructor parse(IConstructor grammar, String sort, String src,
			ISourceLocation loc) {
		if (!cache.containsKey(grammar)) {
			cache.put(grammar, buildParser(grammar, loc));
		}
		try {
			IGTD<IConstructor,IConstructor,ISourceLocation> parser = cache.get(grammar).newInstance();
			return (IConstructor) parser.parse(sort, loc.getURI(),
					src.toCharArray(), MY_ACTION_EXECUTOR,
					new DefaultNodeFlattener<IConstructor, IConstructor, ISourceLocation>(),
					new UPTRNodeFactory());
		} catch (InstantiationException e) {
			throw new ImplementationError("parser generator:" + e.getMessage(), e);
		} catch (IllegalAccessException e) {
			throw new ImplementationError("parser generator:" + e.getMessage(),	e);
		}
	}

	private Class<IGTD<IConstructor,IConstructor,ISourceLocation>> buildParser(IConstructor grammar, ISourceLocation loc) {
		try {
			IString grammarName = makeGrammarName(grammar);
			IString classString = (IString) evaluator.call(
					"generateObjectParser", PKG, grammarName, grammar);
			debugOutput(classString.getValue(), "/tmp/parser.java");
			return bridge.compileJava(loc.getURI(), PKG.getValue() + "."
					+ grammarName.getValue(), classString.getValue());
		} catch (ClassCastException e) {
			throw new ImplementationError("parser generator:" + e.getMessage(),
					e);
		} catch (Throw e) {
			throw new ImplementationError("parser generator: " + e.getMessage()
					+ e.getTrace());
		}
	}

	private IString makeGrammarName(IConstructor grammar) {
		return vf.string("grammar_" + Math.abs(grammar.hashCode()));
	}

	private static final IActionExecutor<IConstructor> MY_ACTION_EXECUTOR = new IActionExecutor<IConstructor>() {

		@Override
		public Object createRootEnvironment() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void completed(Object environment, boolean filtered) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Object enteringProduction(Object production, Object parent) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object enteringListProduction(Object production, Object parent) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object enteringNode(Object production, int index,
				Object environment) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object enteringListNode(Object production, int index,
				Object environment) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void exitedProduction(Object production, boolean filtered,
				Object environment) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void exitedListProduction(Object production, boolean filtered,
				Object environment) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public IConstructor filterProduction(IConstructor tree,
				Object environment) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public IConstructor filterListProduction(IConstructor tree,
				Object environment) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public IConstructor filterAmbiguity(IConstructor ambCluster,
				Object environment) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public IConstructor filterListAmbiguity(IConstructor ambCluster,
				Object environment) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public IConstructor filterCycle(IConstructor cycle, Object environment) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public IConstructor filterListCycle(IConstructor cycle,
				Object environment) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isImpure(Object rhs) {
			// TODO Auto-generated method stub
			return false;
		}

	};

	private void debugOutput(String classString, String file) {
		FileOutputStream s = null;
		try {
			s = new FileOutputStream(file);
			s.write(classString.getBytes());
			s.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (s != null) {
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
