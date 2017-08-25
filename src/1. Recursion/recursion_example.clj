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
  (loop [accum 0
         i     n]
    (if (<= i 1)
      accum
      (recur (inc accum) (quot i 2)))))

(defn countdown
  "Returns the list with: n, n-1, n-2, ..., 2, 1."
  [n]
  (if (< n 1)
    ()
    (cons n (countdown (dec n)))))

(defn howmany
  "Returns how many times x is contained in lst,
  considering nested lists."
  [x lst]
  (cond
    (empty? lst)        0
    (list? (first lst)) (+ (howmany x (first lst))
                           (howmany x (rest lst)))
    (= x (first lst))   (inc (howmany x (rest lst)))
    :else               (howmany x (rest lst))))

(defn fibo
  "Returns the n-th element of the Fibonacci sequence."
  [n]
  (if (<= n 1)
    n
    (+ (fibo (- n 1))
       (fibo (- n 2)))))

(defn fibo-loop
  "Returns the n-th element of the Fibonacci sequence.
  Uses loop/recur"
  [n]
  (loop [a 0N
         b 1N
         i 0]
    (if (= i n)
      a
      (recur b (+ a b) (inc i)))))
