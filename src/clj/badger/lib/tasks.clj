(ns badger.lib.tasks
  (:require [environ.core :refer [env]]
            [clj-http.client :as http]))

(defn- url
  [product]
  (clojure.string/replace (env :assembly-url) ":product" product))

(defn count-tasks
  [product]
  (-> (url product)
      (http/get {:accept :json
                 :as :json})
      (:body)
      (:total)))

