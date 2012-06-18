module lang::synclj::meta::AST

data MetaGrammar
  = grammar(list[Rule] rules)
  ;
  
data Rule
  = rule(str name, list[Alt] alts)
  ;
  
data Alt
  = alt(str name, list[Exp] elements)
  ;

data Exp
  = literal(str text) // todo: escape and unquote
  | nonTerminal(str name)
  | mapLit(list[Exp] args)
  | vectorLit(list[Exp] args)
  | listLit(list[Exp] args)
  | setLit(list[Exp] args)
  | fnLit(list[Exp] args)
  | quote(Exp arg)
  | qquote(Exp arg)
  | unquote(Exp arg)
  | unquotes(Exp arg)
  | deref(Exp arg)
  | metaIdent()
  | metaString()
  | metaMap(list[Exp] args)
  | opt(Exp arg)
  | star(Exp arg)
  | plus(Exp arg)
  | starSep(Exp arg, str sep)
  | plusSep(Exp arg, str sep) 
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

