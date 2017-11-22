(use '[clojure.core.logic :rename {== ===}])
(require '[clojure.core.logic.fd :as fd])

(defn addo
  "Logical function that succeeds if the sum of
  all elements in lst is equal to result."
  [lst result]
  (conde
    [(=== lst [])
     (=== result 0)]

    [(fresh [head tail temp]
       (conso head tail lst)
       (addo tail temp)
       (fd/+ head temp result))]))

(defn magic-square
  "Solves the magic square puzzle."
  []
  (run* [q1 q2 q3
         q4 q5 q6
         q7 q8 q9]
       (fd/in q1 q2 q3 q4 q5 q6 q7 q8 q9 (fd/interval 1 9))
       (distincto [q1 q2 q3 q4 q5 q6 q7 q8 q9])
       (addo [q1 q2 q3] 15)
       (addo [q4 q5 q6] 15)
       (addo [q7 q8 q9] 15)
       (addo [q1 q4 q7] 15)
       (addo [q2 q5 q8] 15)
       (addo [q3 q6 q9] 15)
       (addo [q1 q5 q9] 15)
       (addo [q7 q5 q3] 15)))