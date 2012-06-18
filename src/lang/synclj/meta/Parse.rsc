module lang::synclj::meta::Parse

import lang::synclj::meta::MetaGrammar;
import ParseTree;

public MetaGrammar parseGrammar(str src, loc l) = parse(#MetaGrammar, src, l);
