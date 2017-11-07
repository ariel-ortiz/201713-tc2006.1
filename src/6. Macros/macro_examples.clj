(defmacro my-comment
  [& arg]
  nil)

(defn my-comment-fun
  [arg]
  nil)

(defmacro my-and
  ([] true)
  ([x] x)
  ([x & y]
   `(let [t# ~x]
      (if t#
        (my-and ~@y)
        t#))))

(defmacro debug
  [expr]
  `(let [result# ~expr]
     (do
       (println "Debug:" '~expr "=>" result#)
       result#)))

(defn fact
  [n]
  (if (zero? n)
    1N
    (do
      (debug n)
      (debug (* n (fact (dec n)))))))

