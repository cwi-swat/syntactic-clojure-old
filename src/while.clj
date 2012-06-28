
; asaksjdhas

(defmacro grammar 
  {:grammar :meta-grammar}
  [ast]
    (do 
      (print (str "AST = " ast))
      (list 'quote ast)))

(def while-grammar (grammar
   Prog = prog {Stat} 
   Stat = assign symbol "=" form
        | skip "skip" (class MetaAmbiguity)
        | if "if" form "then" Prog "else" Prog "fi" (folding)
        | while "while" form "do" Prog "od" (folding) 
        | return "return" form))
        
(defmacro til
  {:grammar while-grammar}
  [ast]
  (do
   (print (str "WHILE: " ast))
   (list 'quote ast)))
  
(def mult (til
    x = n
    while (> n 0) do
       x = (+ x x)
       n = (- n 1)
    od
    return x))

