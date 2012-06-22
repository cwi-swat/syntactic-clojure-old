module lang::synclj::util::Clojure

import ParseTree;
import lang::clojure::Clojure;
import lang::synclj::meta::AST;

@javaClass{lang.clojure.Clojure}
public java Tree compile(start[File] file, Tree(str) metaParser, Tree(MetaGrammar, str) objectParser);
