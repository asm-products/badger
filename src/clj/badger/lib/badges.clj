(ns badger.lib.badges
  (:require [badger.templates.task :as task]))

(defn badge
  [resource n]
  (case resource
    "task" (task/template n)))
