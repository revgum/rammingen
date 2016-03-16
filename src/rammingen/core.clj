(ns rammingen.core
 (:require  [clojure.java.io :as io]))

(def bagit-version 0.97)

(defn mkdir [dir]
  "Make the directory if it doesn't already exist"
  (if-not (.isDirectory (io/file dir))
    (.mkdir (io/file dir))))

(defn copy-file-to-data-dir [rootdir filedir filename]
  "Setup root and data directories, copy file into place in the data directory"
  (let [datadir (format "%s/data" rootdir)
        dest_filepath (format "%s/data/%s" rootdir filename)
        src_filepath (format "%s/%s" filedir filename)]
    (mkdir rootdir)
    (mkdir datadir)
    (io/copy (io/file src_filepath) (io/file dest_filepath))))
