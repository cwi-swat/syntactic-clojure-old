module lang::synclj::ide::Bridge2Clojure

import ParseTree;

@javaClass{clojure.lang.Bridge2Clojure}
public java Tree loadForRascal(str src, loc org);