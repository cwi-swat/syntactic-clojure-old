module lang::synclj::meta::EBNF

extend lang::clojure::syntax::Layout;
extend lang::clojure::syntax::Tokens;

syntax EBNF
  = grammar: "grammar" Rule* // always one, for start symbol
  ;

syntax Rule
  = rule: Symbol "=" {Alt "|"}*
  ;

syntax Alt
  = alt: Symbol Exp* // ident is the cons attribute
  ;
  
syntax Exp
  = literal: String
  | call: Symbol \ Tokens
  | optional: "[" Exp "]"
  | repeat: "{" Exp "}" 
  | repeatSep: "{" Exp String "}"
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

keyword Tokens 
  = "string"
  | "integer"
  | "number"
  | "float"
  | "rational"
  | "char"
  | "keyword"
  | "regexp"
  | "symbol"
  | "form"
  | "grammar"
  | "|" 
  | "=";

