module lang::synclj::meta::NodeImplode

import ParseTree;


public node implode2node(Tree t) {
  if ([node x] := nimplode(t)) {
    return x;
  }
  throw "Tree <t> not a single node";
}

public list[value] nimplode(Tree t) {
  switch (t) {
    case appl(prod(layouts(_), _, _), _):
       return [];
    case appl(prod(lit(_), _, _), _):
       return [];
    case appl(prod(cilit(_), _, _), _):
       return [];
    case appl(prod(label(_, sort("Form")), _, _), _):
       return [t]; // return the full parse tree
    case appl(prod(label(n, _), _, _), as): 
       return [n(( [] | it + nimplode(a) | a <- as ))];
    case appl(regular(_), as):
       return ( [] | it + nimplode(a) | a <- as );
    case appl(prod(lex(n), _, _), _):
       return ["$<n>"("<t>")];
    default: throw "Cannot implode to node: <t>";
  }
}        
