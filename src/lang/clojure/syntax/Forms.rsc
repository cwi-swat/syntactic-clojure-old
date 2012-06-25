module lang::clojure::syntax::Forms

extend lang::clojure::syntax::Layout;
extend lang::clojure::syntax::Tokens;

syntax Form
  = string: String
  | regexp: RegExp
  | char: Char
  | number: Number
  | arg: Arg
  | meta: ("#^"|"^") Form meta Form arg
  | symbol: Symbol
  | \list: "(" Form* ")" 
  | vector: "[" Form* "]"
  | \map: "{" Form* "}"
  | \set: "#{" Form* "}"
  | fn: "#(" Form* ")"
  | var: "#\'" Form 
  | deref: "@" Form
  | unquote: "~" !>> [@] Form arg
  | unquotes: "~@" Form arg
  | quote: "\'" Form arg
  | qquote: "`" Form arg
  | discard: "#_" Form
  //| "#=" Eval
  //| "#!" Comment
  //| "#\<" Unreadable
  ;
  
lexical Arg
  = [%] !>> [&1-9]
  | [%] [1-9][0-9]* !>> [0-9]
  | [%][&]
  ;
