;==========================================================
; Type your student ID and name here.
;==========================================================

(use 'clojure.test)

;==========================================================
(defn isqrt
  "Integer square root. Returns a vector [p q] where
  n = p^2 + q."
  [n]
  (let [result (->>
                 (range (inc n))
                 (take-while #(<= (* % %) n))
                 last)]
    [result (- n (* result result))]))

;==========================================================
(defn twos-complement
  "Retuns the two's complement of a list containing only
  ones and zeros."
  [lst]
  (let [[part1 part2] (split-with zero? (reverse lst))
        complement (map #(if (zero? %) 1 0) (rest part2))]
    (reverse (concat part1 [1] complement))))


;==========================================================
(defn interleave-inverse
  "Inverse interleave operation. uninterleaves lst into n
  subsequences."
  [n lst]
  (for [i (range n)]
    (take-nth n (drop i lst))))

;==========================================================
(deftest test-isqrt
  (is (= [0 0]     (isqrt 0)))
  (is (= [1 0]     (isqrt 1)))
  (is (= [1 1]     (isqrt 2)))
  (is (= [1 2]     (isqrt 3)))
  (is (= [2 1]     (isqrt 5)))
  (is (= [4 8]     (isqrt 24)))
  (is (= [9 16]    (isqrt 97)))
  (is (= [25 41]   (isqrt 666)))
  (is (= [256 0]   (isqrt 65536)))
  (is (= [316 144] (isqrt 100000))))

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
(deftest test-interleave-inverse
  (is (= '((a b c d e) (1 2 3 4 5))
         (interleave-inverse 2 '(a 1 b 2 c 3 d 4 e 5))))
  (is (= '((a 1 b 2 c 3 d 4 e 5))
         (interleave-inverse 1 '(a 1 b 2 c 3 d 4 e 5))))
  (is (= '((a b c d e) (1 2 3 4 5) (v w x y z))
         (interleave-inverse 3 '(a 1 v b 2 w c 3 x d 4 y e 5 z))))
  (is (= '((0 5 10 15 20 25)
           (1 6 11 16 21 26)
           (2 7 12 17 22 27)
           (3 8 13 18 23 28)
           (4 9 14 19 24 29))
         (interleave-inverse 5 (range 30)))))

;==========================================================
(run-tests)
