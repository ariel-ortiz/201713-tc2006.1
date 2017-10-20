; Example using the pmap function.

(defn ranges
  "Returns a list of p vectors containing all available
  equal size ranges from 0 (inclusive) to n (exclusive)."
  [n p]
  (let [delta (/ n p)]
    (->>
      (range 0 n delta)
      (map (fn [x] [x (+ x delta)])))))

(defn compute-pi
  "Computes a chunk of pi using numerical integration
  from start to end and the given number of rectangles."
  [num-rects start end]
  (let [width (/ 1.0 num-rects)]
    (* (loop [i   start
              sum 0.0]
         (if (= i end)
           sum
           (let [mid (* (+ i 0.5) width)
                 height (/ 4.0 (+ 1.0 (* mid mid)))]
             (recur (inc i) (+ sum height)))))
       width)))

(defn pi
  "Uses pmap to compute the value of pi in parallel."
  [num-rects n]
  (->>
    (pmap (fn [[start end]] (compute-pi num-rects start end))
          (ranges num-rects n))
    (reduce +)))
