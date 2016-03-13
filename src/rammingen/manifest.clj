(ns rammingen.manifest
  (:require  [clojure.java.io :as io]
             [rammingen.core :refer :all]))

(defn write-manifest [dir alg files]
  "Write the manifest-<algorithm>.txt file, where <algorithm> matches the checksum algorithm used in that manifest. spec-url: https://tools.ietf.org/html/draft-kunze-bagit-13#section-2.1.3"
  (let [filename (format "%s/manifest-%s.txt" dir alg) encoding "UTF-8"]
    (if-not (.isDirectory (io/file dir))
      (.mkdir (io/file dir)))
    (if (.exists (io/file filename))
      (throw (Exception. (format "File already exists: %s" filename)))
      (with-open [w (io/writer filename :encoding encoding)]
        ; loop through the files passed in to generate the manifest file
        (doseq [f files]
          ; TODO: calculate the checksum for each file using the algorithm
          ; provided
          (.write w (format "####### %s\n" f))
        )))))
