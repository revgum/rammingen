(ns rammingen.manifest
  (:require  [clojure.java.io :as io]
             [rammingen.core :refer :all :as c]
             [digest]))

(defn write-manifest [dir alg files]
  "Write the manifest-<algorithm>.txt file, where <algorithm> matches the checksum algorithm used in that manifest. spec-url: https://tools.ietf.org/html/draft-kunze-bagit-13#section-2.1.3"
  (let [filename (format "%s/manifest-%s.txt" dir alg) encoding "UTF-8"]
    (c/mkdir dir)
    (if (.exists (io/file filename))
      (throw (Exception. (format "manifest file already exists: %s" filename)))
      (with-open [w (io/writer filename :encoding encoding)]
        ; loop through the files passed in to generate the appropriate manifest file
        (doseq [f files]
          ; manifest file requires that the files are located in the data
          ; directory
          (let [file (io/file (format "%s/data/%s" dir f))]
            (if (= alg "md5")
              (.write w (format "%s data/%s\n" (digest/md5 file) f))
              (.write w (format "%s data/%s\n" (digest/sha1 file) f)))))))))
