(ns rammingen.bag-test
  (:require [clojure.test :refer :all]
            [clojure.java.io :as io]
            [rammingen.bag :refer :all])
  (:import (java.util UUID)))

(def seed-id (UUID/randomUUID))
(def temp-dir (str (System/getProperty "user.dir") "/tmp/" seed-id))
(println (str "Running tests using directory: " temp-dir))

(deftest write-bag-it-test
  (rammingen.bag/write-bag-it temp-dir)
  (testing "Write the bagit.txt file"
    (is (= (.exists (io/file (str temp-dir "/bagit.txt")))) "file wasn't found in directory")))
