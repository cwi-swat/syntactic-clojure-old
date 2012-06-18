module Plugin

import lang::clojure::syntax::Clojure;
import lang::clojure::check::Check;
import lang::clojure::util::Parse;

import ParseTree;
import util::IDE;

public void main() {
  registerLanguage("Clojure", "clj", Tree(str src, loc l) {
     return parseClojure(src, l);
  });
  contribs = {
     annotator(Tree(start[File] t) { return check(t); })
  };
   
  registerContributions("Clojure", contribs);
}