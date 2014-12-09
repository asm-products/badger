(ns badger.lib.redis
  (:require [taoensso.carmine :as car]))

(defn- redis-url
  []
  (or (System/getenv "REDISCLOUD_URL") "redis://127.0.0.1:6379"))

(defn- conn-spec
  []
  (let [
    url (redis-url)]))

(def redis-conn {:pool {} :spec (conn-spec)})
(defmacro with-car [& body] `(car/wcar redis-conn ~@body))
