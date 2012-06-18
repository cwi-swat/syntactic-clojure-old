module lang::synclj::meta::Implode

import lang::synclj::meta::AST;
import ParseTree;

public MetaGrammar implodeGrammar(Tree t) = implode(#MetaGrammar, t);
