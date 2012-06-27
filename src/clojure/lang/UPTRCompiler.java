package clojure.lang;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;

import lang.clojure.syntax.ClojureParser;

import org.eclipse.imp.pdb.facts.IConstructor;
import org.eclipse.imp.pdb.facts.IList;
import org.eclipse.imp.pdb.facts.IListWriter;
import org.eclipse.imp.pdb.facts.ISetWriter;
import org.eclipse.imp.pdb.facts.ISourceLocation;
import org.eclipse.imp.pdb.facts.IString;
import org.eclipse.imp.pdb.facts.IValueFactory;
import org.rascalmpl.parser.gtd.IGTD;
import org.rascalmpl.parser.gtd.util.ArrayList;
import org.rascalmpl.parser.uptr.NodeToUPTR;
import org.rascalmpl.values.Message;
import org.rascalmpl.values.ValueFactoryFactory;
import org.rascalmpl.values.uptr.TreeAdapter;

import clojure.asm.Type;

public class UPTRCompiler extends Compiler {
	private static final String START_SORT = "start__File";

	// have to copy, because private in Compiler.
	private static final Type VAR_TYPE = Type.getType(Var.class);
	
	private final IValueFactory vf;

	private final ISetWriter errors;
	
	public UPTRCompiler(IValueFactory vf, ISetWriter errors) {
		this.vf = vf;
		this.errors = errors;
	}
	
	// TODO: this class needs some refactoring... Too much duplication.
	
	public static IConstructor loadForRascal(IValueFactory vf, IString src, ISourceLocation loc) {
		IGTD gtd = new ClojureParser();
		IConstructor file = (IConstructor) gtd.parse(START_SORT, loc.getURI(), 
				src.getValue().toCharArray(), new NodeToUPTR());
		
		String path = loc.getURI().getPath();
		IConstructor[] fileRef = new IConstructor[] {file};
		
		// ignore the clojure result
		ISetWriter errors = vf.setWriter(Message.Message);
		new UPTRCompiler(vf, errors).loadPT(fileRef, path, new File(path).getName());
		
		// return the updated parse tree.
		return fileRef[0].setAnnotation("messages", errors.done());
	}

	
	public static Object loadWithRascal(Reader rdr, String sourcePath, String sourceName) {
		IValueFactory vf = ValueFactoryFactory.getValueFactory();
		UPTRCompiler c = new UPTRCompiler(vf, null);
		return c.load2(rdr, sourcePath, sourceName);
	}
	
	public Object load2(Reader rdr, String sourcePath, String sourceName) {
		char[] input = convertReader(rdr);
		return loadFromChars(input, sourcePath, sourceName);
	}

	private Object loadFromChars(char[] input, String sourcePath,
			String sourceName) {
		IGTD gtd = new ClojureParser();
		IConstructor file = (IConstructor) gtd.parse(START_SORT, URI.create(sourcePath), input, new NodeToUPTR());
		
		IConstructor filePt = (IConstructor)file;
		return loadPT(new IConstructor[] {filePt}, sourcePath, sourceName);
	}
	
	public Object loadPT(IConstructor[] fileRef, String sourcePath, String sourceName) {
		IConstructor file = fileRef[0];
		ISourceLocation loc = TreeAdapter.getLocation(file);
		int lineNumber = loc.getBeginLine();
		
		Object ret = null;
		
		Var.pushThreadBindings(
				RT.map(LOADER, RT.makeClassLoader(),
				       SOURCE_PATH, sourcePath,
				       SOURCE, sourceName,
				       METHOD, null,
				       LOCAL_ENV, null,
						LOOP_LOCALS, null,
						NEXT_LOCAL_NUM, 0,
				       RT.CURRENT_NS, RT.CURRENT_NS.deref(),
				       LINE_BEFORE, lineNumber,
				       LINE_AFTER, lineNumber
				       ,RT.UNCHECKED_MATH, RT.UNCHECKED_MATH.deref()
						,RT.WARN_ON_REFLECTION, RT.WARN_ON_REFLECTION.deref()
				       ,RT.DATA_READERS, RT.DATA_READERS.deref()
	                        ));

		UPTRLispReader reader = new UPTRLispReader(vf, errors);
		
		try
			{
			
			if (TreeAdapter.isAmb(file)) {
				System.err.println("Amb");
			}
			
			// File is start[File], so
			IConstructor file2 = (IConstructor) TreeAdapter.getArgs(file).get(1);
			IList args = TreeAdapter.getArgs(file2);
			// Probably only this is the list of forms; don't forget to fix below.
			IList forms = TreeAdapter.getArgs((IConstructor) args.get(0));


			IListWriter newArgs = vf.listWriter();
			for (int i = 0; i < forms.length(); i++) {
				IConstructor form = (IConstructor) forms.get(i);
				// only forms, no literals at this level.
				UPTRLispReader.Pair p = reader.read(form);
				newArgs.append(p.tree);
				LINE_AFTER.set(TreeAdapter.getLocation(form).getEndLine());
				ret = eval(p.obj, false);
				LINE_BEFORE.set(TreeAdapter.getLocation(form).getBeginLine());
				if (i < forms.length() - 2) {
					i++;
					newArgs.append(forms.get(i)); // layout
				}
			}
			// Fix tree
			file2 = file2.set("args", newArgs.done());
			file = file.set("args", vf.list(TreeAdapter.getArgs(file).get(0),file2, TreeAdapter.getArgs(file).get(2)));

			}
		catch(LispReader.ReaderException e)
			{
			throw new CompilerException(sourcePath, e.line, e.getCause());
			}
		finally
			{
			Var.popThreadBindings();
			}
		fileRef[0] = file;
		return ret;
	}

	// Copied from Rascal's InputConverter
	private final static int STREAM_READ_SEGMENT_SIZE = 8192;
	private char[] convertReader(Reader reader) {
		ArrayList<char[]> segments = new ArrayList<char[]>();
		
		// Gather segments.
		int nrOfWholeSegments = -1;
		int bytesRead;
		do{
			char[] segment = new char[STREAM_READ_SEGMENT_SIZE];
			try {
			bytesRead = reader.read(segment, 0, STREAM_READ_SEGMENT_SIZE);
			}
			catch (IOException e) {
				throw new RuntimeException(e);
			}
			
			segments.add(segment);
			++nrOfWholeSegments;
		}while(bytesRead == STREAM_READ_SEGMENT_SIZE);
		
		// Glue the segments together.
		char[] segment = segments.get(nrOfWholeSegments);
		char[] input;
		if(bytesRead != -1){
			input = new char[(nrOfWholeSegments * STREAM_READ_SEGMENT_SIZE) + bytesRead];
			System.arraycopy(segment, 0, input, (nrOfWholeSegments * STREAM_READ_SEGMENT_SIZE), bytesRead);
		}else{
			input = new char[(nrOfWholeSegments * STREAM_READ_SEGMENT_SIZE)];
		}
		for(int i = nrOfWholeSegments - 1; i >= 0; --i){
			segment = segments.get(i);
			System.arraycopy(segment, 0, input, (i * STREAM_READ_SEGMENT_SIZE), STREAM_READ_SEGMENT_SIZE);
		}
		
		return input;
	}

}
