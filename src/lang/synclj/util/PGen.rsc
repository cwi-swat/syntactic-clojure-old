module lang::synclj::util::PGen

import Grammar;
import ParseTree;

@javaClass{lang.synclj.util.PGen}
public java Tree parse(Grammar grammar, str sort, str src, loc org);
