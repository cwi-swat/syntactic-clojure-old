module lang::clojure::syntax::Forms

extend lang::clojure::syntax::Layout;
extend lang::clojure::syntax::Tokens;

syntax Form
  = string: String
  | regexp: RegExp
  | char: Char
  | number: Number
  | arg: MetaData* Arg
  | symbol: MetaData* Symbol
  | \list: MetaData* "(" Form* ")" 
  | vector: MetaData* "[" Form* "]"
  | \map: MetaData* "{" Form* "}"
  | \set: MetaData* "#{" Form* "}"
  | fn: MetaData* "#(" Form* ")"
  | var: MetaData* "#\'" Form 
  | deref: MetaData* "@" Form
  | unquote: MetaData* "~" !>> [@] Form arg
  | unquotes: MetaData* "~@" Form arg
  | quote: MetaData* "\'" Form arg
  | qquote: MetaData* "`" Form arg
  | discard: "#_" Form
  | "#^" Symbol
  //| "#=" Eval
  //| "#!" Comment
  //| "#\<" Unreadable
  ;
  
syntax MetaData
  = @category="MetaVariable" ident: "^" Ident // or symbol?
  | @category="MetaVariable" string: "^" String 
  | @category="MetaVariable" \map: "^" "{" Form* "}"
  ;

lexical Arg
  = [%] !>> [&1-9]
  | [%] [1-9][0-9]* !>> [0-9]
  | [%][&]
  ;
