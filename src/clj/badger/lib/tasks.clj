(ns badger.lib.tasks
  (:require [environ.core :refer [env]]
            [clj-http.client :as http]
            [taoensso.carmine :as car]
            [badger.lib.redis :refer (with-car)]))

(defn product-key-exists?
  [product-key]
  (if (= 1 (with-car (car/exists product-key)))
    true
    false))

(defn- url
  [product]
  (clojure.string/replace (env :assembly-url) ":product" product))

(defn count-tasks
  [product]
  (if-not (product-key-exists? product)
    (with-car (car/set product 
      (-> (url product)
        (http/get {:accept :json
                   :as :json})
        (:body)
        (:total))))
    (with-car (car/expire product 300)))
  (with-car (car/get product)))

