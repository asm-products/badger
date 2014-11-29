(ns badger.lib.badges
  (:require [clojure.xml :as xml]
            [clojure.data.xml :refer [element emit-str parse]]
            [clojure.walk :refer [postwalk]]
            [badger.templates.task :as task]))

(defn b
  [resource n]
  (let [x (case resource
            "task" (task/template (str n)))]
    (emit-str x)))

(defn badge
  [resource n]
  (case resource
    "task" (task/template n)))
