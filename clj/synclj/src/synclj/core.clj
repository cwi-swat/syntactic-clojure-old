(ns synclj.core)


(defmacro defp [name args & body]
  `(defmacro ~name ~args {:parsing true} ~@body))

;; (defp grammar [src org]
;;   `(fn [src org] 
;;      (parse src org ~(check-grammar (parse-grammar src org)))))

(defn parse [src org grammar] nil)

(defmacro deflang [name check compile grammar]
  `(defp ~name [src# org#]
     `(fn [~src1# ~org1#]
        (~~compile (~~check ~(parse src# org# ~grammar))))))


(defn check-grammar [g] nil)
(defn compile-grammar [g] nil)

(deflang grammar check-grammar compile-grammar :meta-grammar)


(defn check-stm [g] nil)
(defn compile-stm [g] nil)

(deflang stm check-stm compile-stm (grammar "blabla" 2))

