module lang::synclj::meta::AST

data EBNF
  = grammar(list[Rule] rules)
  ;
  
data Rule
  = rule(str name, list[Alt] alts)
  ;
  
data Alt
  = alt(str name, list[Exp] elements, list[Hints] hints)
  ;
  
data Hints
  = hints(list[Hint] hints)
  ;
  
data Hint
  = class(str name)
  | folding()
  ;

data Exp
  = literal(str text) // todo: escape and unquote
  | call(str name)
  | optional(Exp arg)
  | repeat(Exp arg)
  | repeatSep(Exp arg, str sep)
  | string()
  | integer()
  | number()
  | float()
  | rational()
  | char()
  | keyword()
  | regexp()
  | symbol()
  | form()
  ;

