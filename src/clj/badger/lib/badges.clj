(ns badger.lib.badges
  (:require [badger.templates.task :as task]
            [badger.lib.tasks :as tasks]))

(defn- task-count-for
  [product]
  (tasks/count-tasks product))

(defn- get-task-count
  [product]
  (let [n (task-count-for product)]
    (task/template n)))

(defn badge
  [product resource]
  (case resource
    "task" (get-task-count product)))
