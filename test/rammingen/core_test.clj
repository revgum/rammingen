(ns rammingen.core-test
  (:require [clojure.test :refer :all]
            [rammingen.core :refer :all]))

(deftest bagit-version-test
  (testing "TagIt version"
    (is (= rammingen.core/bagit-version 0.97) "has a mismatched version")))
