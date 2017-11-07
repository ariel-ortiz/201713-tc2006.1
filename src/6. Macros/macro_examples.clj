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

(defn between-keywords
  [start end lst]
  (->>
    (drop-while #(not= start %) lst)
    rest
    (take-while #(not= end %))))

(defmacro IF
  [condition & args]
  `(if ~condition
     (do ~@(between-keywords :THEN :ELSE args))
     (do ~@(between-keywords :ELSE :THEN args))))
