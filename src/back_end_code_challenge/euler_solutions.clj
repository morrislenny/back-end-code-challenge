(ns back-end-code-challenge.euler-solutions
  (require [clojure.string :as str]))

;;;; Problem 1
;;; If we list all the natural numbers below 10 that are multiples of 3 or 5,
;;; we get 3, 5, 6 and 9. The sum of these multiples is 23.
;;; Find the sum of all the multiples of 3 or 5 below 1000.
(defn multiple?
  "Helper function to (problem-1). Takes a number,
  and returns it if the number is a multiple of 3 or 5, or returns false if it is not."
  [n]
  (or (== (mod n 3) 0) (== (mod n 5) 0)))

(defn problem-1
  "Solution to problem-1. Generates a range of integers from 0 to 1000,
  filters out numbers that are not multiples of 3 or 5, and sums the remaining sequence.
  The result is 233168."
  []
  (reduce + (filter multiple? (range 0 1000))))

;;;; Problem 2
;;; Each new term in the Fibonacci sequence is generated by adding the previous
;;; two terms. By starting with 1 and 2, the first 10 terms will be:

;;; 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

;;; By considering the terms in the Fibonacci sequence whose values do not
;;; exceed four million, find the sum of the even-valued terms.
(defn fib
  "Helper function for (problem-2). Creates a lazy sequence of fibonacci numbers."
  ([]
   (fib 1 1))
  ([a b]
   (lazy-seq (cons a (fib b (+ a b))))))

(defn problem-2 []
  "Solution to problem-2. Takes fibonacci numbers that are less than four million,
  and sums the even ones.The result is 4613732."
  (reduce + (filter even? (take-while #(<= % 4000000) (fib)))))

;;;; Problem 4
;;; A palindromic number reads the same both ways. The largest palindrome made
;;; from the product of two 2-digit numbers is 9009 = 91 × 99.
;;; Find the largest palindrome made from the product of two 3-digit numbers.

;(require '[clojure.string :as str])

(defn is-palindrome? [n]
  (= (str n) (str/reverse (str n))))

(defn problem-4
  "Solution to problem-4. This function needs clojure.string as formatted in the comment above.
  It finds every combination of three digit integers multiplied together, and filters out the
  non-palindromic numbers. It then finds the maximum value of the remaining sequence.
  The result is 906609."
  []
  (apply max
    (filter is-palindrome?
      (for [x (range 100 999)
            y (range 100 999)]
        (* x y)))))

;;;; Problem 9
;;; A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
;;; a2 + b2 = c2
;;; For example, 32 + 42 = 9 + 16 = 25 = 52.
;;; There exists exactly one Pythagorean triplet for which a + b + c = 1000.
;;; Find the product abc.
(defn pythagorean-triplet?
  "takes in a vector with a and b, it then computes c based on the constraint
  of the problem, and checks if a, b, and c are a phythagorean triplet."
  [v]
  (let [a (v 0)
        b (v 1)
        c (- 1000 a b)]
    (and (> c 0) (== (+ (* a a) (* b b)) (* c c)))))

(defn multiply
  "Takes a, and b from a vector v, computes c based on the constraint of the
  problem, and then multip a, b, and c together."
  [v]
  (let [a (v 0)
        b (v 1)
        c (- 1000 a b)]
        (* a b c)))

(defn problem-9
  "Solution to problem 9. The answer is 31875000."
  []
  (some #(when (pythagorean-triplet? %) (multiply %))
        (for [x (range 1 1001)
              y (range x 1001)]
          [x y])))