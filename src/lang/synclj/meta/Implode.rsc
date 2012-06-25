module lang::synclj::meta::Implode

import lang::synclj::meta::AST;
import ParseTree;

public EBNF implodeGrammar(Tree t) = implode(#EBNF, t);
