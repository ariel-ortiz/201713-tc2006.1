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
