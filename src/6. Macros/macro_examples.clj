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

