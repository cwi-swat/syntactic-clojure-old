
; asaksjdhas

(defmacro grammar 
  {:grammar :meta-grammar}
  [ast]
    (do 
      (print (str "AST = " ast))
      (list 'quote ast)))

(def while-grammar (grammar
   Prog = prog {Stat} 
   Stat = symbol "=" form
        | skip "skip"
        | if "if" form "then" Prog "else" Prog "fi"
        | while "while" form "do" Prog "od" 
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

