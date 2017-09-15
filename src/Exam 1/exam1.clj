;==========================================================
; Type your student ID and name here.
;==========================================================

(use 'clojure.test)

;==========================================================
(defn babylonian
  "Computes the square root of s using the Babylonian
  method with n iterations."
  [s n]
  0)

;==========================================================
(defn twos-complement
  "Retuns the two's complement of a list containing only
  ones and zeros."
  [lst]
  ())

;==========================================================
(use 'clojure.math.numeric-tower)

(defn aprox=
  "Checks if x is approximately equal to y. Returns true
  if |x - y| < epsilon, or false otherwise."
  [epsilon x y]
  (< (abs (- x y)) epsilon))

(deftest test-babylonian
  (is (aprox= 0.0001
              1
              (babylonian 1 0)))
  (is (aprox= 0.0001
              1.4142
              (babylonian 2 3)))
  (is (aprox= 0.0001
              4
              (babylonian 16 5)))
  (is (aprox= 0.00000000001
              31.62277660168
              (babylonian 1000 9))))

;==========================================================
(deftest test-twos-complement
  (is (= '(1)
         (twos-complement '(1))))
  (is (= '(1 1 1 1 1 1 1 1)
         (twos-complement '(0 0 0 0 0 0 0 1))))
  (is (= '(0 0 0 0 0 0 0 1)
         (twos-complement '(1 1 1 1 1 1 1 1))))
  (is (= '(1 0 0 0 0 0 0 0)
         (twos-complement '(1 0 0 0 0 0 0 0))))
  (is (= '(1 0 1 0 0 1 1 0 1 0)
         (twos-complement '(0 1 0 1 1 0 0 1 1 0))))
  (is (= '(0 1 0 1 0 1 1 0 1 1 1 1 0 0 0 0)
         (twos-complement '(1 0 1 0 1 0 0 1 0 0 0 1 0 0 0 0)))))

;==========================================================
(run-tests)

