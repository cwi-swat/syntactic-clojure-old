
; asaksjdhas



(def ebnf '(grammar [
   (rule Grammar [(alt grammar [(literal "grammar") (repeat (call Rule))])])
   (rule Rule [(alt rule [(symbol) (literal "=") (repeatSep (call Alt) (literal "|"))])])
   (rule Alt [(alt alt [(symbol) (repeat (call Exp))])])
   (rule Exp [
                (alt literal [(string)]) 
                (alt call [(symbol)])
                (alt optional [(literal "[") (call Exp) (literal "]")]) 
                (alt repeat [(literal "{") (call Exp) (literal "}") ])
                (alt repeatSep [(literal "{") (call Exp) (string) (literal "}")])

		;; tokens
                (alt symbol [(literal "symbol")])
                (alt integer [(literal "integer")])
                (alt string [(literal "string")])
                (alt regexp [(literal "regexp")])
                (alt float [(literal "float")])
                (alt rational [(literal "rational")])
                (alt number [(literal "number")])
                (alt char [(literal "char")])
                (alt form [(literal "form")])
                ])
   ]))

(defmacro grammar 
  {:grammar :meta-grammar}
  [ast]
    (print ast))

(def while (grammar
   Prog = prog {Stat}
   Stat = assign symbol "=" form
        | skip "skip"
        | if "if" form "then" Prog "else" Prog "fi"
        | while "while" form "do" Prog "od" 
        | return "return" form))
        
;(def mult [n] (while
;    x = n.
;    while (> n 0) do
;       x = (+ x x).
;       n = (- n 1)
;    od.
;    return x))
