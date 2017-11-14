(use '[clojure.core.logic :rename {== ===}])

(defn lasto
  "Logical function that succeeds if the last element
  of lst is result."
  [lst result]
  (conde
    [(=== lst [result])]
    [(fresh [head tail]
       (conso head tail lst)
       (lasto tail result))]))

(defn reverseo
  "Logical function that succeeds if the reverse of lst
  is result."
  [lst result]
  (conde
    [(=== lst ())
     (=== result ())]

    [(fresh [head tail temp]
       (conso head tail lst)
       (reverseo tail temp)
       (appendo temp [head] result))]))