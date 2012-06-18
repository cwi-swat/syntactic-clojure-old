

(def meta-grammar '(grammar [
                             (rule "MetaGrammar" [(alt "grammar" [(plus (nonTerminal "Rule"))])])
                             (rule "Rule" [(alt "rule" [:ident (literal "=") (plusSep (nonTerminal "Alt") (literal "|"))])])
                             (rule "Alt" [(alt "alt" [:ident (star (nonTerminal "Exp"))])])
                             (rule "Exp" [
                                          (alt "literal" [:string])
                                          (alt "nonTerminal" [:ident])
                                          (alt "mapLit" [])
                                          (alt "vectorLit" [])
                                          (alt "listLit" [])
                                          (alt "setLit" [])
                                          (alt "fnLit" [])
                                          (alt "quote" [])
                                          (alt "qquote" [])
                                          (alt "unquote" [])
                                          (alt "unquotes" [])
                                          (alt "deref" [])
                                          (alt "metaIdent" [])
                                          (alt "metaString" [])
                                          (alt "metaMap" [])
                                          (alt "opt" [])
                                          (alt "star" [])
                                          (alt "plus" [])
                                          (alt "starSep" [])
                                          (alt "plusSep" [])
                                          (alt "ident" [(literal "ident")])
                                          (alt "" [])
                                          (alt "" [])
                                          (alt "" [])
                                          ])
                             ])
                                   
  | ident: "ident"   // these correspond to atomic tokens in Clojure
  | string: "string"
  | integer: "integer"
  | number: "number"
  | float: "float"
  | rational: "rational"
  | char: "char"
  | keyword: "keyword"
  | regexp: "regexp"
  | symbol: "symbol"
  | form: "form" // escape to clojure
  ;