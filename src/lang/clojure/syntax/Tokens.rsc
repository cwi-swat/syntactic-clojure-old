module lang::clojure::syntax::Tokens

lexical Number
  = integer: Integer
  | ratio: Ratio
  | float: Float
  ;
  
lexical Symbol
  = Ident
  | Ident "/" Ident
  | "::" Ident
  // prevent amb with namespace / 
  | [a-zA-Z0-9+*\-|&!?\<\>=.#_$] !<< "/" !>> [:a-zA-Z+*\-|&!?\<\>=._]
  ;
  
lexical Ident
  = ":"? {Stem ":"}+ !>> [a-zA-Z0-9+*\-|&!?\<\>=.#_$\']
  ;

// do hihglighting using annotations otherwise this grammar is not reusable.
// TODO: fix the multiplicity of follow/precede restrictions  
lexical Stem
  =  ([a-zA-Z0-9+*\-|&!?\<\>=.#_$] !<< [a-zA-Z+*|&!?\<\>=._] [a-zA-Z0-9+*\-|&!?\<\>=.#_$]* !>> [a-zA-Z0-9+*\-|&!?\<\>=.#_$\']) 
  |  ([a-zA-Z0-9+*\-|&!?\<\>=.#_$] !<< [a-zA-Z+*|&!?\<\>=._] [a-zA-Z0-9+*\-|&!?\<\>=.#_$]* [\']+ !>> [\'])
  // special case of symbols starting with -, otherwise ambiguous with integers
  |  ([a-zA-Z0-9+*\-|&!?\<\>=.#_$] !<< [\-] [a-zA-Z0-9+*\-|&!?\<\>=.#_$]* [a-zA-Z+*\-|&!?\<\>=.#_$] [a-zA-Z0-9+*\-|&!?\<\>=.#_$]*  !>> [a-zA-Z0-9+*\-|&!?\<\>=.#_$\'])
  |  ([a-zA-Z0-9+*\-|&!?\<\>=.#_$] !<< [\-] [a-zA-Z0-9+*\-|&!?\<\>=.#_$]* [a-zA-Z0-9+*|&!?\<\>=.#_$] [a-zA-Z0-9+*\-|&!?\<\>=.#_$]* [\']+ !>> [\'])
  |  ([a-zA-Z0-9+*\-|&!?\<\>=.#_$] !<< [\-] [\']+ !>> [\'])
  |  [a-zA-Z0-9+*\-|&!?\<\>=.#_$] !<< [\-] !>> [a-zA-Z0-9+*\-|&!?\<\>=.#_$\']
  ;

lexical Char
  = [\\] ![\t\ \r\n\f\b]
  | [\\] "space"
  | [\\] "newline"
  | [\\] "return"
  | [\\] "formfeed"
  | [\\] "backspace"
  | [\\] "tab"
  ;
  
lexical String
  = @category="StringLiteral" [\"] StrChar* [\"]
  ;
  
lexical StrChar
  = ![\\\"] 
  | [\\][\"\\nbtfr]
  | [\\][u][0-9a-fA-F][0-9a-fA-F][0-9a-fA-F][0-9a-fA-F]  
  | [\\][0-3][0-7][0-7]
  ;
  

lexical RegExp
  = [#] [\"] (![\"] | ([\\][\"]))* [\"] // todo: all escapes
  ;


lexical Integer
  = [\-+]? IntValue [N]?
  ;
  
lexical IntValue 
  = [0] !>> [0-7xX]
  | [1-9][0-9]* !>> [0-9]
  | [0][xX] [0-9A-Fa-f]+ !>> [0-9A-Fa-f]
  | [0][0-7]+ !>> [0-7]
  | [1-9][0-9]? [rR] [0-9A-Za-z]+ !>> [0-9A-Za-z]
  //| [0][0-9]+ !>> [0-9]+ // don't know what this is, but is amb with octals
  ;
  
lexical Float
  = [\-+]? FloatValue [M]?
  ;

//static Pattern floatPat = Pattern.compile("([-+]?[0-9]+(\\.[0-9]*)?([eE][-+]?[0-9]+)?)(M)?");  
lexical FloatValue
  = [0-9]+ [.] [0-9]+ !>> [0-9] ([eE][\-+]? [0-9]+ !>> [0-9])?  
  ;
  
//static Pattern ratioPat = Pattern.compile("([-+]?[0-9]+)/([0-9]+)");
lexical Ratio
  = [\-+]? [0-9]+ [/] [0-9]+ !>> [0-9]
  ; 
