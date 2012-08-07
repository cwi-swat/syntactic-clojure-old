package clojure.lang.ide;

import java.util.Iterator;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.imp.language.Language;
import org.eclipse.imp.model.ISourceProject;
import org.eclipse.imp.parser.IMessageHandler;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.parser.ISourcePositionLocator;
import org.eclipse.imp.pdb.facts.IConstructor;
import org.eclipse.imp.pdb.facts.ISourceLocation;
import org.eclipse.imp.pdb.facts.IValue;
import org.eclipse.imp.pdb.facts.IValueFactory;
import org.eclipse.imp.pdb.facts.exceptions.FactTypeUseException;
import org.eclipse.imp.pdb.facts.type.Type;
import org.eclipse.imp.pdb.facts.type.TypeFactory;
import org.eclipse.imp.services.IAnnotationTypeInfo;
import org.eclipse.imp.services.ILanguageSyntaxProperties;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.rascalmpl.interpreter.control_exceptions.Throw;
import org.rascalmpl.interpreter.result.ICallableValue;
import org.rascalmpl.interpreter.utils.RuntimeExceptionFactory;
import org.rascalmpl.parser.gtd.exception.ParseError;
import org.rascalmpl.values.ValueFactoryFactory;

public class ParseController implements IParseController {
	private ISourceProject project;
	private IConstructor parseTree;
	private IPath path;
	private Language language;
	private ICallableValue parser;
	private IDocument document;
	private ICallableValue annotator;
	private ParseJob job;
	private final static IValueFactory VF = ValueFactoryFactory.getValueFactory(); 
	private final static AnnotatorExecutor executor = new AnnotatorExecutor();
	
	public Object getCurrentAst(){
		return parseTree;
	}
	
	public void setCurrentAst(IConstructor parseTree) {
		this.parseTree = parseTree;
	}
	
	public IAnnotationTypeInfo getAnnotationTypeInfo() {
		return null;
	}

	public Language getLanguage() {
		return language;
	}

	public IPath getPath() {
		return path;
	}

	public ISourceProject getProject() {
		return project;
	}

	public ISourcePositionLocator getSourcePositionLocator() {
		return new NodeLocator();
	}

	public ILanguageSyntaxProperties getSyntaxProperties() {
		return null;
	}

	public Iterator<Token> getTokenIterator(IRegion region) {
		return new TokenIterator(true, parseTree);
	}

	public void initialize(IPath filePath, ISourceProject project, IMessageHandler handler) {
		this.path = filePath;
		this.project = project;
		TermLanguageRegistry reg = TermLanguageRegistry.getInstance();
		this.language = reg.getLanguage(path.getFileExtension());
		this.parser = reg.getParser(this.language);
		this.annotator = reg.getAnnotator(this.language);
		this.job = new ParseJob(language.getName() + " parser", VF.sourceLocation(ProjectURIResolver.constructProjectURI(project, path)), handler);
	}

	public IDocument getDocument() {
		return document;
	}
	
	public Object parse(IDocument doc, IProgressMonitor monitor) {
		if (doc == null) {
			return null;
		}
		this.document = doc;
		return parse(doc.get(), monitor);
	}
	
	private class ParseJob extends Job {
		private final IMessageHandler handler;
		private final ISourceLocation loc;
		
		private String input;
		public IConstructor parseTree = null;

		public ParseJob(String name, ISourceLocation loc, IMessageHandler handler) {
			super(name);
			
			this.loc = loc;
			this.handler = handler;
		}
		
		public void initialize(String input) {
			this.input = input;
		}
		
		@Override
		protected IStatus run(IProgressMonitor monitor) {
			RascalMonitor rm = new RascalMonitor(monitor);
			rm.startJob("Parsing Term", 105);
			
			try{
				handler.clearMessages();
				TypeFactory TF = TypeFactory.getInstance();
				if (parser != null) {
					synchronized (parser.getEval()) {
						parseTree = (IConstructor) parser.call(rm, new Type[] {TF.stringType(), TF.sourceLocationType()}, new IValue[] { VF.string(input), loc}).getValue();
					}
					if (parseTree != null && annotator != null) {
						rm.event("annotating", 5);
						IConstructor newTree = executor.annotate(annotator, parseTree, handler);
						if (newTree != null) {
							parseTree = newTree;
						}
					}
				}
			}
			catch (ParseError pe){
				int offset = pe.getOffset();
				if(offset == input.length()) --offset;
				
				handler.handleSimpleMessage("parse error", offset, offset + pe.getLength(), pe.getBeginColumn(), pe.getEndColumn(), pe.getBeginLine() + 1, pe.getEndLine() + 1);
			} 
			catch (Throw e) {
				IValue exc = e.getException();
				
				if (exc.getType() == RuntimeExceptionFactory.Exception) {
					if (((IConstructor) exc).getConstructorType() == RuntimeExceptionFactory.ParseError) {
						ISourceLocation loc = (ISourceLocation) ((IConstructor) e.getException()).get(0);
						handler.handleSimpleMessage("parse error: " + loc, loc.getOffset(), loc.getOffset() + loc.getLength(), loc.getBeginColumn(), loc.getEndColumn(), loc.getBeginLine(), loc.getEndLine());
					}
					else {
						Activator.getInstance().logException(e.getMessage(), e);
					}
				}
			}
			catch (FactTypeUseException ftuex) {
				Activator.getInstance().logException("parsing " + language.getName() + " failed", ftuex);
			}
			catch (NullPointerException npex){
				Activator.getInstance().logException("parsing " + language.getName() + " failed", npex);
			} 
			catch (Throwable e) {
				Activator.getInstance().logException("parsing " + language.getName() + " failed: " + e.getMessage(), e);
			}
			finally {
				rm.endJob(true);
			}
			
			return Status.OK_STATUS;
		}
	}
	
	public synchronized Object parse(String input, IProgressMonitor monitor){
		parseTree = null;
		try {
			job.initialize(input);
			job.schedule();
			job.join();
			parseTree = job.parseTree;
			return parseTree;
		} catch (InterruptedException e) {
			Activator.getInstance().logException("parser interrupted", e);
		}
		return null;
	}
}
