module lang::synclj::meta::Test

import lang::synclj::meta::Parse;
import lang::synclj::meta::Implode;
import lang::synclj::meta::Lift;

import lang::synclj::util::PGen;

import ParseTree;
import Grammar;
import Ambiguity;
import IO;


public str WHILE_GRAMMAR = 
   "Prog = prog \"while\" {Stat}+
   'Stat = assign ident \"=\" form
   '     | skip \"skip\"
   '     | if \"if\" form \"then\" {Stat}+ \"else\" {Stat}+ \"fi\"
   '     | while \"while\" form \"do\" {Stat}+ \"od\" 
   '     | return \"return\" form";


public str WHILE_PROG = 
  "(while x = n 
  ' while (\> n 0) do
  '    x = (+ x x) 
  '    n = (- n 1)
  ' od 
  ' return x)";
  
public bool testWhile() {
  pt = parseGrammar(WHILE_GRAMMAR, |file:///|);
  ast = implodeGrammar(pt);
  grm = lift(ast, "grammar");
  if (sort(str x) <- grm.starts) {
    wh = parse(grm, x, WHILE_PROG, |file:///|);
    iprintln(diagnose(wh));
  }
  else {
    throw "No start symbol";
  }
  return true;
}