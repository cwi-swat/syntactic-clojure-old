module lang::clojure::util::PGen

import lang::clojure::syntax::Clojure;
import lang::rascal::grammar::ParserGenerator;
import ParseTree;
import Grammar;
import IO;

public void generateClojureParser() {
  name = "ClojureParser";
  src = generateObjectParser("lang.clojure.syntax", name , grammar({sort("File")}, (#File).definitions));
  writeFile(|project://syntactic-clojure/src/lang/clojure/syntax/<name>.java|, src);
}

