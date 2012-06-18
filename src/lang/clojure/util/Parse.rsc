module lang::clojure::util::Parse

import lang::clojure::syntax::Clojure;
import ParseTree;

public start[File] parseClojure(str src, loc l) = parse(#start[File], src, l);
