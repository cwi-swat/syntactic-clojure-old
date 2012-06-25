
; asaksjdhas



(def simple-meta-grammar '(grammar [
   (rule MetaGrammar [(alt grammar [(literal "grammar") (plus (call Rule))])])
   (rule Rule [(alt rule [(symbol) (literal "=") (plusSep (call Alt) (literal "|"))])])
   (rule Alt [(alt alt [(symbol) (star (call Exp))])])
   (rule Exp [
                (alt literal [(string)]) 
                (alt call [(symbol)])
                (alt opt [(literal "(") (call Exp) (literal ")") (literal "?")])
                (alt star [(literal "(") (call Exp) (literal ")") (literal "*")])
                (alt plus [(literal "(") (call Exp) (literal ")") (literal "+")])
                (alt starSep [(literal "(") (call Exp) (string) (literal ")") (literal "*")])
                (alt plusSep [(literal "(") (call Exp) (string) (literal ")") (literal "+")])

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
  {:grammar simple-meta-grammar}
  [ast]
    (print ast))

(def while (grammar
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
