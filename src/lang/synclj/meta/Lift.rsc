module lang::synclj::meta::Lift

import lang::synclj::meta::AST;
import lang::synclj::meta::Forms;
import Grammar;
import ParseTree;
import List;
import String;


/*
todo: extract literals, and subtract from Name/Symbol
*/

public map[Symbol, Production] CLOJURE() = (#Form).definitions;

// 
public str namespace(str ns, str name) = "<ns>$<name>";

public Grammar lift(MetaGrammar g, str ns) = 
  Grammar::grammar({xtop}, (xtop : topRule) + lift(g.rules, ns) + CLOJURE())
  when 
    Symbol top := sort(namespace(g.rules[0].name, ns)),
    Symbol xtop := sort(top.name + "_$$"),
    Production topRule := choice(xtop, {prod(xtop, il([lit("("), top, lit(")")]),{\tag("Foldable"())})});
    
public map[Symbol, Production] lift(list[Rule] rs, str ns)
  = ( sort(namespace(r.name, ns)): lift(r, ns) | r <- rs );
  
public Production lift(Rule r, str ns)  
  = choice(sort(namespace(r.name, ns)), { 
       prod(label(a.name, sort(namespace(r.name, ns))),
           il([lift(e, ns) | e <- a.elements]), {}) | a <- r.alts }); 

private str unquoteString(str s) = substring(s, 1, size(s) - 1);

public list[Symbol] lift(integer(), str ns) = \lex("Integer");
public list[Symbol] lift(string(), str ns) = \lex("String");
public list[Symbol] lift(number(), str ns) = \lex("Number");
public list[Symbol] lift(float(), str ns) = \lex("Float");
public list[Symbol] lift(lang::synclj::meta::AST::char(), str ns) = \lex("Char");
public list[Symbol] lift(string(), str ns) = \lex("String");
public list[Symbol] lift(keyword(), str ns) = \lex("Keyword");
public list[Symbol] lift(symbol(), str ns) =  \lex("Symbol");
public list[Symbol] lift(form(), str ns) = \sort("Form");


// add  conditional follow restrictions on these literals corresponding
// to symbol/ident iff matching symbol? or always?
// (this to enforce closure whitespace rule.
public list[Symbol] lift(literal(s), str ns) = lit(unquoteString(s));
public list[Symbol] lift(call(n), str ns) = sort(namespace(n, ns));

public list[Symbol] lift(optional(x), str ns) = \opt(liftArg(x, ns));
public list[Symbol] lift(repeat(x), str ns) = \iter-star-seps(lift(x, ns), [LAYOUT]);
public list[Symbol] lift(repeatSep(x, s), str ns) = \iter-star-seps(lift(x, ns), makeSep(s)); 

public list[Symbol] makeSep(str literal) = [LAYOUT,\lit(unquoteString(literal)),LAYOUT];

public Symbol LAYOUT = layouts("Standard");

public list[Symbol] il(list[Symbol] syms) = ( [head(syms)] | it + [LAYOUT, sym] | sym <- tail(syms) )
  when size(syms) > 1;
  
public default list[Symbol] il(list[Symbol] syms) = syms;