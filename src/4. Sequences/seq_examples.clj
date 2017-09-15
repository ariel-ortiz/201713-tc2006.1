; First examples using the sequence API.

(use 'clojure.test)

(defn add-list
  "Returns the sum of all the elements of its
   input list, or 0 if its empty."
  [lst]
  (reduce + 0 lst))

(defn list-of-symbols?
  "Returns true if all the elements (possibly zero) contained
   in lst are symbols, or false otherwise."
  [lst]
  (every? symbol? lst))

(defn invert-pairs
  "Takes as an argument a list of vectors containing two
   elements each. It returns a new list with every vector
   pair inverted. "
  [lst]
  (map (fn [[x y]] [y x]) lst))

(defn enlist
  "Returns a list surrounding in a list every upper-level
   element of lst. "
  [lst]
  (map list lst))

(defn insert
  "Takes two arguments: a number n and a list of numbers
   lst in ascending order. It returns a new list with the
   same elements as lst but inserting n in its
   corresponding place."
  [x lst]
  (concat
    (take-while #(< % x) lst)
    (list x)
    (drop-while #(< % x) lst)))

(defn my-sort
  "Takes an unordered list of numbers as an argument, and
   returns a new list with the same elements but in
   ascending order."
  [lst]
  (if (empty? lst)
    ()
    (insert (first lst)
            (my-sort (rest lst)))))

(deftest test-add-list
  (is (= 0 (add-list ())))
  (is (= 10 (add-list '(2 4 1 3))))
  (is (= 55 (add-list '(1 2 3 4 5 6 7 8 9 10)))))

(deftest test-list-of-symbols?
  (is (list-of-symbols? ()))
  (is (list-of-symbols? '(a)))
  (is (list-of-symbols? '(a b c d e)))
  (is (not (list-of-symbols? '(a b c d 42 e))))
  (is (not (list-of-symbols? '(42 a b c)))))

(deftest test-invert-pairs
  (is (= () (invert-pairs ())))
  (is (= '([1 a][2 a][1 b][2 b]))(invert-pairs '([a 1][a 2][b 1][b 2])))
  (is (= '([1 January][2 February][3 March])
         (invert-pairs '([January 1][February 2][March 3])))))

(deftest test-enlist
  (is (= () (enlist ())))
  (is (= '((a) (b) (c)) (enlist '(a b c))))
  (is (= '(((1 2 3)) (4) ((5)) (7) (8)) (enlist '((1 2 3) 4 (5) 7 8)))))

(deftest test-insert
  (is (= '(14) (insert 14 ())))
  (is (= '(4 5 6 7 8) (insert 4 '(5 6 7 8))))
  (is (= '(1 3 5 6 7 9 16) (insert 5 '(1 3 6 7 9 16))))
  (is (= '(1 5 6 10) (insert 10 '(1 5 6)))))

(deftest test-my-sort
  (is (= () (my-sort ())))
  (is (= '(0 1 3 3 4 6 7 8 9) (my-sort '(4 3 6 8 3 0 9 1 7))))
  (is (= '(1 2 3 4 5 6) (my-sort '(1 2 3 4 5 6))))
  (is (= '(1 5 5 5 5 5 5) (my-sort '(5 5 5 1 5 5 5)))))

(run-tests)
