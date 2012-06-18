module lang::synclj::Fixup

import Bootstrap;
import BootAST;
import Lift;
import SubstForm;
import PGen;
import Syntax;

import Grammar;
import ParseTree;
import IO;
import Exception;
import Message;

public str META_GRAMMAR = "grammar";

alias Lang = tuple[str src, Grammar grammar, loc location];

public map[str, Lang] LANGS = (
  // bootstrap grammar grammar; it defines its own start symbol.
  // nb compose copies into the second one and leaves start symbols alone
  META_GRAMMAR : <"bootstrapped",
                  BOOTSTRAP_GRAMMAR(),
                  |project://ext-synt/src/Bootstrap.rsc|>
  
);


// TODO: check whether parsing offsets etc will really be
// relative to the provided loc org. (Answer: no)


public Tree parseEmbedding(Grammar g, str src, loc org) {
  println("INFO: parsing \"<src>\"");
  println("G.starts: <g.starts>");
  if (ParseTree::sort(x) <- g.starts) {
    println("parsing over symbol <x>");
    return parse(g, x, src, org);
  }
  println("Exception!");
  throw "No start symbol in grammar: <g>";
}


public loc fixLoc(loc l, loc off) {
  l.offset += off.offset;
  if (l.begin.line == 0) {
    println("Beginline is 0");
    l.begin.column += off.begin.column;
  }
  l.end.line += off.begin.line - 1;
  l.begin.line += off.begin.line - 1;
  return l;
}

public Tree fixLocs(Tree t, loc off) {
  return visit (t) {
    case Tree x => x[@\loc=fixLoc(x@\loc, off)]
       when x@\loc?
  }
}

public start[Forms] fixup(start[Forms] t) {
  println("Fixing up");
 
  set[Message] errs = {};
  map[loc,str] docs = ();
 
  Tree subst(Tree x) {
    lang = "<x.name>";
    
    println("Embedding <x.name>");
    
    if (!LANGS[lang]?) // function call
      return x;
    
    src = "<x>";  
    Tree emb;
    try {
      emb = parseEmbedding(LANGS[lang].grammar, src, x@\loc);
      docs[x@\loc] = "Embedding of <lang>";
      println("Parsed embedding");
    }
    catch ParseError(loc l): {
      l = fixLoc(l, x@\loc);
      println("Parse error: <l>");
      errs += {error("Parse error", l)};
      return x;
    }
    
    if (lang == META_GRAMMAR) {
      // implode skips external top symbol
      // (maybe make parens bracket?)
      ast = implode(#BootAST::BGrammar, emb);
      println("AST imploded");
    
      if (ast.key == META_GRAMMAR) {
        println("WARNING: attempt to override builtin grammar grammar; ignored.");
        return x;
      }
    
      // add our basic Form grammar
      LANGS[ast.key] = <src, compose(toRascal(ast), BASE_GRAMMAR()), x@\loc>;
    }

    if (lang != META_GRAMMAR) {
       emb@link = LANGS[lang].location;
    }
    return fixLocs(emb, x@\loc);
  }

  t = top-down visit (t) {
    case Tree x => subst(x)
       when x is embed
  }
  return t[@messages=errs][@docs=docs];
}

