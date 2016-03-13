(ns rammingen.bag-test
  (:require [clojure.test :refer :all]
            [rammingen.test-setup :as config]
            [clojure.java.io :as io]
            [rammingen.bag :as bag]))

(deftest write-bag-it-test
  (let [temp_dir config/temp-dir]
    (println (format "write-bag-it-test using directory: %s" temp_dir))
    (bag/write-bag-it temp_dir)
      (testing "Write the bagit.txt file"
        (is (= (.exists (io/file (format "%s/bagit.txt" temp_dir)))) "file wasn't found in directory"))))
