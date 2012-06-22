module lang::synclj::util::Clojure

import ParseTree;
import lang::clojure::syntax::Clojure;
import lang::synclj::meta::AST;

@javaClass{clojure.lang.Clojure}
public java Tree compile(start[File] file, Tree(str) metaParser, Tree(MetaGrammar, str) objectParser);

public Tree dummyMP(str x) {}
public Tree dummyOP(MetaGrammar mg, str x) {}
