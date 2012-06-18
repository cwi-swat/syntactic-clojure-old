module lang::synclj::meta::MetaGrammar

//extend lang::synclj::meta::Mixin;
extend lang::synclj::meta::Layout;
extend lang::clojure::syntax::Tokens;


syntax MetaGrammar
  = grammar: Rule+ // always one, for start symbol
  ;

syntax Rule
  = rule: Ident "=" {Alt "|"}+
  ;

syntax Alt
  = alt: Ident Exp* // ident is the cons attribute
  ;
  
syntax Exp
  = literal: Literal
  | nonTerminal: MetaIdent
  | mapLit: "\"{\"" Exp* "\"}\""
  | vectorLit: "\"[\"" Exp* "\"]\""
  | listLit: "\"(\"" Exp* "\")\""
  | setLit: "\"#{\"" Exp* "\"}\""
  | fnLit: "\"#(\"" Exp* "\")\""
  | quote: "\"\'\"" Exp
  | qquote: "\"`\"" Exp
  | unquote: "\"~\"" Exp
  | unquotes: "\"~@\"" Exp
  | deref: "\"@\"" Exp
  | metaIdent: "\"^\"" "ident" // todo meta data symbol/list/vector/etc....
  | metaString: "\"^\"" "string"
  | metaMap: "\"^\"" "\"{\"" Exp* "\"}\""
  | opt: Exp "?"
  | star: "{" Exp "}" "*"
  | plus: "{" Exp "}" "+"
  | starSep: "{" Exp Literal "}" "*"
  | plusSep: "{" Exp Literal "}" "+" // for any literal encountered in a grammar, 
                            // reserve from ident/symbol and add follow/precede restrictions
                            // to symbol and ident on the  literals...???
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

lexical Literal
  = [\"] MetaLiteral [\"] // !!!
  ;
  
lexical MetaLiteral
  = Symbol
  | Integer
  | IntBase
  | Ratio
  | Float
  | BigDecimal
  | Char
  | String1
  | [,]
  ;  
  
lexical String1
  = [\\][\"] StrChar1* [\\][\"]
  ;

lexical StrChar1
  = ![\\\"]
  | [\\][\\][\\\"nftb]
  ;
  
lexical MetaIdent = Ident \ Tokens;

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
  | "." | "*" | "?" | "+" | "|" | "=";

