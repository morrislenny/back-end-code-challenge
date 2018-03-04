(defn pythagorean-triplet? [vec]
    (let [a (nth vec 0)
          b (nth vec 1)
          c (- 1000 a b)]
        (if (and (> c 0) (== (+ (* a a) (* b b)) (* c c)))
            (* a b c)
            false
        )
    ))
