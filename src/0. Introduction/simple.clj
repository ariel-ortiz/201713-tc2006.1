; First Clojure functions.

(use 'clojure.test)
(use 'clojure.math.numeric-tower)

(defn add1
  "Adds one to x."
  [x]
  (+ x 1))

(defn add2
  "Adds two to y using the add1 function twice."
  [y]
  (add1 (add1 y)))

(defn f2c
  "Converts f degrees Fahrenheit to degrees Celsius."
  [f]
  (/ (* (- f 32) 5) 9))

(defn sign
  "Returns -1 if n is negative, 1 if n is positive
  greater than zero, or 0 if n is zero."
  [n]
  (if (> n 0)
    1
    (if (< n 0) -1 0)))

(defn roots
  "Returns a vector containing the two
  possible roots that solve a quadratic
  equation given its three coefficients
  (a, b, c)."
  [a b c]
  (let [d  (- b)
        e  (sqrt (- (* b b) (* 4 a c)))
        f  (* 2 a)
        x1 (/ (+ d e) f)
        x2 (/ (- d e) f)]
    [x1 x2]))

(defn bmi
  "It returns a symbol that represents the
  corresponding BMI description computed
  from its input."
  [weight heigt]
  (let [BMI (/ weight (* heigt heigt))]
    (cond
      (< BMI 20) 'underweight
      (< BMI 25)  'normal
      (< BMI 30) 'obese1
      (< BMI 40) 'obese2
      :else 'obese3)))

(deftest test-add1
  (is (= 6 (add1 5)))
  (is (= -9 (add1 -10)))
  (is (= 0 (add1 -1))))

(deftest test-add2
  (is (= 12 (add2 10)))
  (is (= 0 (add2 -2)))
  (is (= 100 (add2 98))))

(deftest test-f2c
  (is (= 100.0 (f2c 212.0)))
  (is (= 0.0 (f2c 32.0)))
  (is (= -40.0 (f2c -40.0))))

(deftest test-sign
  (is (= -1 (sign -5)))
  (is (= 1 (sign 10)))
  (is (= 0 (sign 0))))

(deftest test-roots
  (is (= [-1.0 -1.0] (roots 2.0 4.0 2.0)))
  (is (= [0.0 0.0] (roots 1.0 0.0 0.0)))
  (is (= [-0.25 -1.0] (roots 4.0 5.0 1.0))))

(deftest test-bmi
  (is (= 'underweight (bmi 45 1.7)))
  (is (= 'normal (bmi 55 1.5)))
  (is (= 'obese1 (bmi 76 1.7)))
  (is (= 'obese2 (bmi 81 1.6)))
  (is (= 'obese3 (bmi 120 1.6))))

(run-tests)
