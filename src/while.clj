
; asaksjdhas

`(a b ~`
~(casasa) 
d)

(def while (grammar
   Prog = prog {Stat "."}+.
   Stat = assign ident "=" form
        | skip "skip"
        | if "if" form "then" Prog "else" Prog "fi"
        | while "while" form "do" Prog "od" 
        | return "return" form.))
        
(def mult [n] (while
    x = n.
    while (> n 0) do
       x = (+ x x).
       n = (- n 1)
    od.
    return x))