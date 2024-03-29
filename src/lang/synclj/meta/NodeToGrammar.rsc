module lang::synclj::meta::NodeToGrammar

import lang::synclj::meta::NodeToAST;
import lang::synclj::meta::Lift;
import Grammar;
import IO;

public Grammar node2Grammar(str ns, str key, node n) = lift(node2EBNF(n), ns, key);

