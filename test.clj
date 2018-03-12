(defn -main
    [n]
    (= (str n) (reverse (str n))))

(defn high-palindrome
    []
    (for x (range 999 100) y (range 999 100)
        (filter max #(= (str n) (reverse (str n))))))
