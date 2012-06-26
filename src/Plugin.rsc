module Plugin

import lang::synclj::ide::Bridge2Clojure;
import util::IDE;

public void main() {
  registerLanguage("Syntactic Clojure", "sclj", loadForRascal);
}
