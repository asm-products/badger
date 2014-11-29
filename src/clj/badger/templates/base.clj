(ns badger.templates.base
  (:require [hiccup.core :refer [html]]))

(defn svg
  [& elems]
  (html [:svg {:width "300px"
               :height "78px"
               :xmlns "http://www.w3.org/2000/svg"
               :xmlns:xlink "http://www.w3.org/1999/xlink"
               :xml:space "preserve"}
         elems]))

(defn label
  [l]
  (html [:text {:x "110"
                :y "52"
                :width "88px"
                :style "font-family: Helvetica; font-size: 36px; fill: #3e3e3e;"}
         l]))

(defn outline []
  (html [:rect {:x "0"
                :y "0"
                :width "300px"
                :height "78px"
                :style "stroke: #979797; stroke-width: 1; fill: none;"}]))