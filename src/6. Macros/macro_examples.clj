(defmacro my-comment
  [& arg]
  nil)

(defn my-comment-fun
  [arg]
  nil)

(defmacro my-and
  [x y]
  `(if ~x
     (if ~y true false)
     false))