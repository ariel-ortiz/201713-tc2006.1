; First Clojure functions.

(use 'clojure.test)

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

(run-tests)
