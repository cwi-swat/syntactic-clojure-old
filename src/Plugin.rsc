module Plugin

import lang::synclj::ide::Bridge2Clojure;
import util::IDE;
import IO;
import Message;
import ParseTree;

public void main() {
  registerLanguage("Syntactic Clojure", "sclj", Tree(str src, loc org) {
    Tree pt = loadForRascal(src, org);
    iprintln(pt@messages);
    return pt;
  });
}
