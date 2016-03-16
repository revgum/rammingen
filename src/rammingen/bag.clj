(ns rammingen.bag
  (:require  [clojure.java.io :as io]
             [rammingen.core :refer :all :as c]))

(defn write-bag-it [dir]
  "Write the bagit.txt file, encoded as UTF-8, with BagIt version set. spec-url: https://tools.ietf.org/html/draft-kunze-bagit-13#section-2.1.1"
  (let [filename (format "%s/bagit.txt" dir) encoding "UTF-8"]
    (c/mkdir dir)
    (if (.exists (io/file filename))
      (throw (Exception. (format "File already exists: %s" filename)))
      (with-open [w (io/writer filename :encoding encoding)]
        (.write w (format "BagIt-Version: %s\n" rammingen.core/bagit-version))
        (.write w (format "Tag-File-Character-Encoding: %s\n" encoding))))))
