module lang::clojure::syntax::Tokens

syntax Number
  = integer: Integer
  | intbase: IntBase
  | ratio: Ratio
  | float: Float
  | bigdecimal: BigDecimal
  ;
  
lexical Symbol
  = Ident
  | Ident "/" Ident
  | "::" Ident
  // prevent amb with namespace / 
  | [a-zA-Z0-9+*\-|&!?\<\>=.#_$] !<< "/" !>> [:a-zA-Z+*\-|&!?\<\>=._]
  ;
  
lexical Ident
  = ":"? {Stem ":"}+ !>> [a-zA-Z0-9+*\-|&!?\<\>=.#_$]
  ;

// do hihglighting using annotations otherwise this grammar is not reusable.  
lexical Stem
  =  ([a-zA-Z0-9+*\-|&!?\<\>=.#_$] !<< [a-zA-Z+*\-|&!?\<\>=._] [a-zA-Z0-9+*\-|&!?\<\>=.#_$]* !>> [a-zA-Z0-9+*\-|&!?\<\>=.#_$]) 
  ;

lexical Char
  = [\\] ![\t\ \r\n]
  | [\\] "space"
  | [\\] "newline"
  | [\\] "tab"
  ;
  
lexical String
  = @category="StringLiteral" [\"] (![\\\"] | ([\\][\"\\nbtfr]))* [\"]
  ;

lexical RegExp
  = [#] [\"] (![\\\"] | ([\\][\\\"dwWsS.()\[\]?*+]))* [\"] // todo: all escapes
  ;

lexical Integer
  = [\-]?[0-9][0-9]* !>> [0-9]
  ;
  
lexical BigDecimal
  = Float [M]
  ;
  
lexical Float
  = [\-]? [0-9]+ [.] [0-9]+ // todo: exponent
  ;
  
lexical Ratio
  = Integer "/" [1-9][0-9]* !>> [0-9]
  ; 
  
lexical IntBase
  = [2] [r] [\-]? [0-1]+ !>> [0-1]
  | [3] [r] [\-]? [0-2]+ !>> [0-2]
  | [4] [r] [\-]? [0-3]+ !>> [0-3]
  | [5] [r] [\-]? [0-4]+ !>> [0-4]
  | [6] [r] [\-]? [0-5]+ !>> [0-5]
  | [7] [r] [\-]? [0-6]+ !>> [0-6]
  | [8] [r] [\-]? [0-7]+ !>> [0-7]
  | [9] [r] [\-]? [0-8]+ !>> [0-8]
  | [1][0] [r] [\-]? [0-9]+ !>> [0-9]
  | [1][1] [r] [\-]? [0-9aA]+ !>> [0-9aA]
  | [1][2] [r] [\-]? [0-9a-bA-B]+ !>> [0-9a-bA-B]
  | [1][3] [r] [\-]? [0-9a-cA-C]+ !>> [0-9a-cA-C]
  | [1][4] [r] [\-]? [0-9a-dA-D]+ !>> [0-9a-dA-D]
  | [1][5] [r] [\-]? [0-9a-eA-E]+ !>> [0-9a-eA-E]
  | [1][6] [r] [\-]? [0-9a-fA-F]+ !>> [0-9a-fA-F]
  | [1][7] [r] [\-]? [0-9a-gA-G]+ !>> [0-9a-gA-G]
  | [1][8] [r] [\-]? [0-9a-hA-H]+ !>> [0-9a-hA-H]
  | [1][9] [r] [\-]? [0-9a-iA-I]+ !>> [0-9a-iA-I]
  | [2][0] [r] [\-]? [0-9a-jA-J]+ !>> [0-9a-jA-J]
  | [2][1] [r] [\-]? [0-9a-kA-K]+ !>> [0-9a-kA-K]
  | [2][2] [r] [\-]? [0-9a-lA-L]+ !>> [0-9a-lA-L]
  | [2][3] [r] [\-]? [0-9a-mA-M]+ !>> [0-9a-mA-M]
  | [2][4] [r] [\-]? [0-9a-nA-N]+ !>> [0-9a-nA-N]
  | [2][5] [r] [\-]? [0-9a-oA-O]+ !>> [0-9a-oA-O]
  | [2][6] [r] [\-]? [0-9a-pA-P]+ !>> [0-9a-pA-P]
  | [2][7] [r] [\-]? [0-9a-qA-Q]+ !>> [0-9a-qA-Q]
  | [2][8] [r] [\-]? [0-9a-rA-R]+ !>> [0-9a-rA-R]
  | [2][9] [r] [\-]? [0-9a-sA-S]+ !>> [0-9a-sA-S]
  | [3][0] [r] [\-]? [0-9a-tA-T]+ !>> [0-9a-tA-T]
  | [3][1] [r] [\-]? [0-9a-uA-U]+ !>> [0-9a-uA-U]
  | [3][2] [r] [\-]? [0-9a-vA-V]+ !>> [0-9a-vA-V]
  | [3][3] [r] [\-]? [0-9a-wA-W]+ !>> [0-9a-wA-W]
  | [3][4] [r] [\-]? [0-9a-xA-X]+ !>> [0-9a-xA-X]
  | [3][5] [r] [\-]? [0-9a-yA-Y]+ !>> [0-9a-yA-Y]
  | [3][6] [r] [\-]? [0-9a-zA-Z]+ !>> [0-9a-zA-Z]
  ;
