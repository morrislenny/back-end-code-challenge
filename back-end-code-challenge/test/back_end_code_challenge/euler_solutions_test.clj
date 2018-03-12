(ns back-end-code-challenge.euler-solutions-test
  (:require [clojure.test :refer :all]
            [back-end-code-challenge.euler-solutions :refer :all]))

;;;; Problem 1 Tests

;;; multiple? Tests
;; Tests a number not divisible by 3 or 5.
;; This number is 7, should return false.
(deftest multiple?-notDivisible
  (testing "should NOT have been divisible by 3 or 5"
    (is (not (multiple? 7)))))
;; Tests that a number is divisible by 3, or 5.
;; Tests (multiple? 6), and (multiple? 20), should be true
(deftest multiple?-divisbleByOne
  (testing "should be divisible by 3 or 5"
    (is (and (multiple? 6)
             (multiple? 20)))))
;; Tests that a number is divisble by both 3 and 5.
;; Tests (multiple? 15), should be true.
(deftest multiple?-divisbleByTwo
  (testing "15 should be divisible by 3 and 5"
    (is (multiple? 15))))

;;; (problem-1) Test
;; Tests if (problem-1) returns 233168
(deftest problem-1-test
  (testing "Result should be 233168"
    (is (= (problem-1) 233168))))

;;;; Problem 2 Tests

;;; (fib a b) Tests
;; (take 2 (fib))
(deftest fib-take-2
  (testing "result should be (1 1)"
    (is (= (take 2 (fib))
           '(1 1)))))
;; (take 20 (fib))
(deftest fib-take-20
  (testing "the last item in the list should equal 6765"
    (is (= (last (take 20 (fib))) 6765))))

;;; (problem-2) Test
(deftest problem-2-test
  (testing "the solution should be 4613732"
    (is (= (problem-2) 4613732))))

;;;; Problem 4 Tests

;;; (is-palindrome? n) Tests
;; (is-palindrome? 123454321)
(deftest is-palindrome?-123454321
  (testing "should return true"
    (is (is-palindrome? 123454321))))
;; (is-palindrome? 1201)
(deftest is-palindrome?-1201
  (testing "should return false"
    (is (not (is-palindrome? 1201)))))

;;; (problem-4) Test
(deftest problem-4-test
  (testing "should return 906609"
    (is (= (problem-4) 906609))))

;;;; Problem 9 Tests

;;; (pythagorean-triplet? [a b]) Tests
;; (pythagorean-triplet? [1 9])
(deftest pythagorean-triplet?-1-9
  (testing "1^2 + 9^2 NOT EQUALS 990^2"
    (pythagorean-triplet? [1 9])))
;; (pythagorean-triplet? [200 375])
(deftest pythagorean-triplet?-200-375
  (testing "200^2 + 375^2 EQUALS (1000-200-375)^2"
    (pythagorean-triplet? [200 375])))

;;; (problem-9) Test
(deftest problem-9-test
  (testing "result should be 31875000"
    (is (= (problem-9) 31875000))))
