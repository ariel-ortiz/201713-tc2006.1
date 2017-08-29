; The classical Lisp symbolic differentiator.
;
; Taken from section 2.3.2, of “Structure and Interpretation of Computer
; Programs”, second edition, by Harold Abelson, Gerald Jay Sussman, and
; Julie Sussman, published by The MIT Press.

(declare variable? same-variable? sum? addend augend make-sum
         product? multiplier multiplicand make-product)

(defn deriv
  "Takes an algebraic expression exp and a variable var and returns
   the derivative of the expression with respect to the variable."
  [exp var]
  (cond

    (number? exp)    0

    (variable? exp)  (if (same-variable? exp var) 1 0)

    (sum? exp)       (make-sum (deriv (addend exp) var)
                               (deriv (augend exp) var))

    (product? exp)   (make-sum (make-product
                                 (multiplier exp)
                                 (deriv (multiplicand exp) var))
                               (make-product
                                 (multiplicand exp)
                                 (deriv (multiplier exp) var)))

    :else            (throw
                       (IllegalArgumentException.
                         (str "unknown expression type: " exp)))))

(defn variable?
  "Returns true if x is a variable, false otherwise."
  [x]
  (symbol? x))

(defn same-variable?
  "Returns true if v1 and v2 are the same variable, false otherwise."
  [v1 v2]
  (and (variable? v1)
       (variable? v2)
       (= v1 v2)))

(defn make-sum
  "Returns a representation of the sum of a1 and a2."
  [a1 a2]
  (cond
    (= a1 0)          a2
    (= a2 0)          a1
    (and (number? a1)
         (number? a2))  (+ a1 a2)
    :else               (list '+ a1 a2)))

(defn make-product
  "Returns a representation of the product of m1 and m2."
  [m1 m2]
  (cond
    (or (= m1 0) (= m2 0)) 0
    (= m1 1)                   m2
    (= m2 1)                   m1
    (and (number? m1)
         (number? m2))         (* m1 m2)
    :else                      (list '* m1 m2)))

(defn sum?
  "Returns true if exp is a sum, false otherwise."
  [exp]
  (and (list? exp)
       (= '+ (first exp))))

(defn product?
  "Returns true is exp is a product, false otherwise."
  [exp]
  (and (list? exp)
       (= '* (first exp))))

(defn addend
  "Returns the addend (addition's first operand) of exp."
  [exp]
  (nth exp 1))

(defn augend
  "Returns the augend (addition's second operand) of exp."
  [exp]
  (nth exp 2))

(defn multiplier
  "Returns the multiplier (product's first operand) of exp."
  [exp]
  (nth exp 1))

(defn multiplicand
  "Returns the multiplicand (product's second operand) of exp."
  [exp]
  (nth exp 2))
