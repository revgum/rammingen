(ns rammingen.manifest-test
  (:require [clojure.test :refer :all]
            [rammingen.test-setup :as config]
            [clojure.java.io :as io]
            [rammingen.manifest :as manifest]))

(deftest write-manifest-test
  (let [temp_dir config/temp-dir]
    (println (format "write-manifest-test using directory: %s" temp_dir))
    (manifest/write-manifest temp_dir "rc5" '("one" "two"))
      (testing "Write the manifest-rc5.txt file"
        (is (= (.exists (io/file (format "%s/manifest-%s.txt" temp_dir "rc5")))) "file wasn't found in directory"))))
