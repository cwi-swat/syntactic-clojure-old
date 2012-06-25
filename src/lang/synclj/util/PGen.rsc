module lang::synclj::util::PGen

import lang::synclj::meta::MetaGrammar;
import lang::rascal::grammar::ParserGenerator;
import ParseTree;
import Grammar;
import IO;

public void generateGrammarParser() {
  name = "GrammarParser";
  src = generateObjectParser("lang.synclj.syntax", name , grammar({sort("MetaGrammar")}, (#MetaGrammar).definitions));
  writeFile(|project://clojure-rascal/src/lang/synclj/syntax/<name>.java|, src);
}

