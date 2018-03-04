; Problem 1
; If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
; Find the sum of all the multiples of 3 or 5 below 1000.
(defn multiple?
    "Helper function to (problem-1). Takes a number,
    and returns it if the number is a multiple of 3 or 5, or returns false if it is not."
    [n]
    (if (or (== (mod n 3) 0) (== (mod n 5) 0))
        n
        false))
(defn problem-1 []
    "Solution to problem-1. Generates a range of integers from 0 to 1000,
    filters out numbers that are not multiples of 3 or 5, and sums the remaining sequence.
    The result is 233168."
    (reduce + (filter multiple? (range 0 1000))))

; Problem 4
;A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
;Find the largest palindrome made from the product of two 3-digit numbers.
;(require '[clojure.string :as str])
(defn is-palindrome? [n]
    (= (str n) (str/reverse (str n))) n)
(defn problem-4 []
    "Solution to problem-4. This function needs clojure.string as formatted in the comment above.
    It finds every combination of three digit integers multiplied together, and filters out the
    non-palindromic numbers. It then finds the maximum value of the remaining sequence.
    The result is 996004."
    (apply max (filter is-palindrome? (for [x (range 100 999) y (range 100 999)] (* x y)))))
