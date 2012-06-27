module lang::synclj::meta::Lift

import lang::synclj::meta::AST;
import lang::clojure::syntax::Forms;
import Grammar;
import ParseTree;
import List;
import String;


private Symbol RESERVED = keywords("RESERVED");
private Symbol LAYOUT = layouts("Standard");


public str namespace(str name, str ns) = "<ns>$<name>";

public Grammar lift(EBNF g, str ns, str key) { 
   Symbol top = \sort(namespace(g.rules[0].name, ns));
   Symbol xtop = \sort(top.name + "_$$");
   lits = { s | /literal(s) <- g };
   reservedRule = choice(RESERVED, { prod(RESERVED, [lit(s)], {}) | s <- lits });
   topRule = choice(xtop, {prod(xtop, il([lit(key), top]) ,{\tag("Foldable"())})});
   clojure = (#Form).definitions;
   return Grammar::grammar({xtop}, (xtop : topRule, RESERVED: reservedRule) + lift(g.rules, ns, lits) + clojure);
}
  
    
public map[Symbol, Production] lift(list[Rule] rs, str ns, set[str] lits)
  = ( sort(namespace(r.name, ns)): lift(r, ns, lits) | r <- rs );
  
public Production lift(Rule r, str ns, set[str] lits)  
  = choice(sort(namespace(r.name, ns)), { 
       prod(label(a.name, sort(namespace(r.name, ns))),
           il([lift(e, ns, lits) | e <- a.elements]), {}) | a <- r.alts }); 

private str unquoteString(str s) = s; //substring(s, 1, size(s) - 1);

public Symbol lift(integer(), str ns, set[str] lits) = \lex("Integer");
public Symbol lift(string(), str ns, set[str] lits) = \lex("String");
public Symbol lift(number(), str ns, set[str] lits) = \lex("Number");
public Symbol lift(float(), str ns, set[str] lits) = \lex("Float");
public Symbol lift(lang::synclj::meta::AST::char(), str ns, set[str] lits) = \lex("Char");
public Symbol lift(string(), str ns, set[str] lits) = \lex("String");
public Symbol lift(keyword(), str ns, set[str] lits) = \lex("Keyword");

public Symbol lift(symbol(), str ns, set[str] lits) =  
  conditional(\lex("Symbol"), {delete(RESERVED)});

public Symbol lift(form(), str ns, set[str] lits) = \sort("Form");

public Symbol lift(literal(s), str ns, set[str] lits) = lit(unquoteString(s));
public Symbol lift(call(n), str ns, set[str] lits) = sort(namespace(n, ns));

public Symbol lift(optional(x), str ns, set[str] lits) = \opt(lift(x, ns, lits));
public Symbol lift(repeat(x), str ns, set[str] lits) = \iter-star-seps(lift(x, ns, lits), [LAYOUT]);
public Symbol lift(repeatSep(x, s), str ns, set[str] lits) = \iter-star-seps(lift(x, ns, lits), makeSep(s)); 

public list[Symbol] makeSep(str literal) = [LAYOUT,\lit(unquoteString(literal)),LAYOUT];

public list[Symbol] il(list[Symbol] syms) = ( [head(syms)] | it + [LAYOUT, sym] | sym <- tail(syms) )
  when size(syms) > 1;
  
public default list[Symbol] il(list[Symbol] syms) = syms;