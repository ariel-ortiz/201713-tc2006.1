; Examples using recursion.

(defn !
  "Returns the factorial of n."
  [n]
  (if (zero? n)
    1N
    (* n (! (dec n)))))

(defn dup
  "Returns a list with every element of
  lst duplicated."
  [lst]
  (if (empty? lst)
    ()
    (cons (first lst)
          (cons (first lst)
                (dup (rest lst))))))

(defn log2
  "Returns the base 2 logarithm of n."
  [n]
  (if (<= n 1)
    0
    (inc (log2 (quot n 2)))))
