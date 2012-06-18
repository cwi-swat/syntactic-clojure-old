module lang::synclj::meta::Lift

import lang::synclj::meta::AST;
import lang::synclj::meta::Mixin;
import Grammar;
import ParseTree;
import List;
import String;


/*
todo: extract literals, and subtract from Name/Symbol
*/

public map[Symbol, Production] META_CLOJURE_LEX() = (#Meta).definitions;

// 
public str namespace(str ns, str name) = "<ns>$<name>";

public Grammar lift(MetaGrammar g, str ns) = 
  Grammar::grammar({xtop}, (xtop : topRule) + lift(g.rules, ns) + META_CLOJURE_LEX())
  when 
    Symbol top := sort(namespace(g.rules[0].name, ns)),
    Symbol xtop := sort(top.name + "_$$"),
    Production topRule := choice(xtop, {prod(xtop, il([lit("("), top, lit(")")]),{\tag("Foldable"())})});
    
public map[Symbol, Production] lift(list[Rule] rs, str ns)
  = ( sort(namespace(r.name, ns)): lift(r, ns) | r <- rs );
  
public Production lift(Rule r, str ns)  
  = choice(sort(namespace(r.name, ns)), { prod(label(a.name, sort(namespace(r.name, ns))),il(flift(a.elements, ns)), {}) | a <- r.alts }); 

private str unquoteString(str s) = substring(s, 1, size(s) - 1);

public list[Symbol] flift(list[Exp] elts, str ns) = ( [] | it + flift(e, ns) | e <- elts );

public list[Symbol] flift(mapLit(args), str ns) = [lit("{"), *flift(args, ns),lit("}")];
public list[Symbol] flift(vectorLit(args), str ns) = [lit("["), *flift(args, ns),lit("]")];
public list[Symbol] flift(listLit(args), str ns) = [lit("("), *flift(args, ns),lit(")")];
public list[Symbol] flift(setLit(args), str ns) = [lit("#{"), *flift(args, ns),lit("}")];
public list[Symbol] flift(fnLit(args), str ns) = [lit("#("), *flift(args, ns),lit(")")];

public list[Symbol] flift(quote(arg), str ns) = [lit("\'"), *flift(arg, ns)];
public list[Symbol] flift(qquote(arg), str ns) = [lit("`"), *flift(arg, ns)];
public list[Symbol] flift(unquote(arg), str ns) = [lit("~"), *flift(arg, ns)];
public list[Symbol] flift(unquotes(arg), str ns) = [lit("~@"), *flift(arg, ns)];
public list[Symbol] flift(deref(arg), str ns) = [lit("@"), *flift(arg, ns)];

public list[Symbol] flift(metaIdent(), str ns) = [lit("^"), \lex("Ident")];
public list[Symbol] flift(metaString(), str ns) = [lit("^"), \lex("String")];
public list[Symbol] flift(metaMap(args), str ns) = [lit("^"),lit("{"), *flift(args),lit("}")];


public list[Symbol] flift(integer(), str ns) = [\lex("Integer")];
public list[Symbol] flift(string(), str ns) = [\lex("String")];
public list[Symbol] flift(number(), str ns) = [\lex("Number")];
public list[Symbol] flift(float(), str ns) = [\lex("Float")];
public list[Symbol] flift(lang::synclj::meta::AST::char(), str ns) = [\lex("Char")];
public list[Symbol] flift(string(), str ns) = [\lex("String")];
public list[Symbol] flift(keyword(), str ns) = [\lex("Keyword")];
public list[Symbol] flift(symbol(), str ns) = [\lex("Symbol")];
public list[Symbol] flift(form(), str ns) = [\sort("Form")];


// add  conditional follow restrictions on these literals corresponding
// to symbol/ident iff matching symbol? or always?
// (this to enforce closure whitespace rule.
public list[Symbol] flift(literal(s), str ns) = [lit(unquoteString(s))];
public list[Symbol] flift(nonTerminal(n), str ns) = [sort(namespace(n, ns))];

public list[Symbol] flift(lang::synclj::meta::AST::opt(x), str ns) = [\opt(fliftArg(x, ns))];
public list[Symbol] flift(star(x), str ns) = [\iter-star-seps(fliftArg(x, ns), [LAYOUT])];
public list[Symbol] flift(plus(x), str ns) = [\iter-seps(fliftArg(x, ns), [LAYOUT])];
public list[Symbol] flift(starSep(x, s), str ns) = [\iter-star-seps(fliftArg(x, ns), makeSep(s))]; 
public list[Symbol] flift(plusSep(x, s), str ns) = [\iter-seps(fliftArg(x, ns), makeSep(s))];

public Symbol fliftArg(Exp arg, ns) = s 
  when [Symbol s] := flift(arg, ns);
   
public default Symbol fliftArg(Exp arg, str ns) = seq(flift(arg, ns));

public list[Symbol] makeSep(str literal) = [LAYOUT,\lit(unquoteString(literal)),LAYOUT];

public Symbol LAYOUT = layouts("Meta");

public list[Symbol] il(list[Symbol] syms) = ( [head(syms)] | it + [LAYOUT, sym] | sym <- tail(syms) )
  when size(syms) > 1;
  
public default list[Symbol] il(list[Symbol] syms) = syms;