module Plugin

import lang::synclj::ide::Bridge2Clojure;
import util::IDE;
import IO;
import Message;
import ParseTree;

private str SYNCLJ = "Syntactic Clojure";

public void main() {
  registerLanguage(SYNCLJ, "sclj", loadForRascal);
  contribs = {
    annotator(Tree(Tree t) { return t; })
  };
  registerContributions(SYNCLJ, contribs);
}
