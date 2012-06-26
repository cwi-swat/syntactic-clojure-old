module lang::synclj::meta::NodeToAST

import lang::synclj::meta::AST;

// take a generic node to a typed EBNF constructor.

public EBNF node2EBNF("grammar"(rs)) = grammar([ node2Rule(r) | r <- rs]);
public Rule node2Rule("rule"("$symbol"(n), as)) = rule(n, [ node2Alt(a) | a <- as ]);
public Alt node2Alt("alt"("$symbol"(n), es)) = alt(n, [ node2Exp(e) | e <- es ]);

public Exp node2Exp("literal"(str s)) = literal(s);
public Exp node2Exp("call"("$symbol"(s))) = call(s);
public Exp node2Exp("optional"(a)) = optional(node2Exp(a));
public Exp node2Exp("repeat"(a)) = repeat(node2Exp(a));
public Exp node2Exp("repeatSep"(a, s)) = repeatSep(node2Exp(a), s);
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

public node example = 
"grammar"(["rule"("$symbol"("Prog"),["alt"("$symbol"("prog"),
["repeat"("call"("$symbol"("Stat")))])]),"rule"("$symbol"("Stat"),["alt"("$symbol"("assign"),
["symbol"(),"literal"("="),"form"()]),"alt"("$symbol"("skip"),["literal"("skip")]),"alt"("$symbol"("if"),
["literal"("if"),"form"(),"literal"("then"),"call"("$symbol"("Prog")),"literal"("else"),
"call"("$symbol"("Prog")),"literal"("fi")]),"alt"("$symbol"("while"),["literal"("while"),
"form"(),"literal"("do"),"call"("$symbol"("Prog")),"literal"("od")]),
"alt"("$symbol"("return"),["literal"("return"),"form"()])])])
;


