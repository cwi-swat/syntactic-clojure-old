module lang::synclj::util::APIGen

import APIGen;
import lang::synclj::meta::AST;


public void generateGrammarAPI() {
  src = apiGen("MetaGrammar", [#Exp, #Alt, #Rule, #MetaGrammar]);
  writeFile(|project://clojure-rascal/src/lang/synclj/values/<name>.java|, src);
}