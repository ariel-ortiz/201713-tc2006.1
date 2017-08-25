(declare variable? same-variable? sum? addend augend make-sum
  product? multiplier multiplicand make-product)

(defn deriv
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
  [x]
  (symbol? x))

(defn same-variable?
  [v1 v2]
  (and (variable? v1)
       (variable? v2)
       (= v1 v2)))

(defn make-sum
  [a1 a2]
  (cons '+ (cons a1 (cons a2 ()))))


