module lang::synclj::meta::NodeToGrammar

import lang::synclj::meta::NodeToAST;
import lang::synclj::meta::Lift;
import Grammar;

public Grammar node2Grammar(str ns, node n) = lift(node2EBNF(n), ns);

