module lang::synclj::meta::PGen

//import lang::synclj::meta::MetaGrammar;
import lang::synclj::meta::EBNF;
import lang::rascal::grammar::ParserGenerator;
import ParseTree;
import Grammar;
import IO;

//public void generateMetaGrammarParser() {
//  name = "MetaGrammarParser";
//  src = generateObjectParser("lang.synclj.meta", name , grammar({sort("MetaGrammar")}, (#MetaGrammar).definitions));
//  writeFile(|project://syntactic-clojure/src/lang/synclj/meta/<name>.java|, src);
//}

public void generateEBNFParser() {
  name = "EBNFParser";
  src = generateObjectParser("lang.synclj.meta", name , grammar({sort("EBNF")}, (#EBNF).definitions));
  writeFile(|project://syntactic-clojure/src/lang/synclj/meta/<name>.java|, src);
}

