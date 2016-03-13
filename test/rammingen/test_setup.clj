(ns rammingen.test-setup
  (:import (java.util UUID)))

(def seed-id (UUID/randomUUID))
(def temp-dir (format "%s/tmp/%s" (System/getProperty "user.dir") seed-id))
