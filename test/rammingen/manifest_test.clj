(ns rammingen.manifest-test
  (:require [clojure.test :refer :all]
            [rammingen.test-setup :as config]
            [clojure.java.io :as io]
            [rammingen.manifest :as manifest]
            [rammingen.core :refer :all :as c]))

(deftest write-manifest-test
  (let [temp_dir config/temp-dir]
    (println (format "write-manifest-test using directory: %s" temp_dir))
    (c/copy-file-to-data-dir temp_dir "/tmp" "testfile.txt")
    (manifest/write-manifest temp_dir "md5" '("testfile.txt" "testfile.txt"))
      (testing "Write the manifest-md5.txt file"
        (is (= (.exists (io/file (format "%s/manifest-%s.txt" temp_dir "md5")))) "file wasn't found in directory"))
    (manifest/write-manifest temp_dir "sha1" '("testfile.txt" "testfile.txt"))
      (testing "Write the manifest-sha1 file"
        (is (= (.exists (io/file (format "%s/manifest-%s.txt" temp_dir "sha1")))) "file wasn't found in directory"))
    )
)
