module lang::synclj::meta::NodeToAST

import lang::synclj::meta::AST;

// take a generic node to a typed EBNF constructor.

public EBNF node2Grammar("grammar"(rs)) = grammar([ node2Rule(r) | r <- rs]);
public Rule node2Rule("rule"("$symbol"(n), as)) = rule(n, [ node2Alt(a) | a <- as ]);
public Alt node2Alt("alt"("$symbol"(n), es)) = alt(n, [ node2Exp(e) | e <- es ]);

public Exp node2Exp("literal"(str s)) = literal(s);
public Exp node2Exp("call"("$symbol"(s))) = call(s);
public Exp node2Exp("optional"(a)) = optional(node2Exp(a));
public Exp node2Exp("repeat"(a)) = repeat(node2Exp(a));
public Exp node2Exp("repeatSep"(a, s)) = repeatSep(node2Exp(a), sep);
public Exp node2Exp("string"()) = string();
public Exp node2Exp("integer"()) = integer();
public Exp node2Exp("number"()) = number();
public Exp node2Exp("float"()) = float();
public Exp node2Exp("rational"()) = rational();
public Exp node2Exp("char"()) = char();
public Exp node2Exp("keyword"()) = keyword();
public Exp node2Exp("regexp"()) = regexp();
public Exp node2Exp("symbol"()) = symbol();
public Exp node2Exp("form"()) = form();



