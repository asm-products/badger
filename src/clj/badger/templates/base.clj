(ns badger.templates.base
  (:require [hiccup.core :refer [html]]))

(defn svg
  [width & elems]
  (html [:svg {:viewBox "0 0 378 78"
               :width (str (* 0.3 width) "px")
               :height "24px"
               :xmlns "http://www.w3.org/2000/svg"
               :xmlns:xlink "http://www.w3.org/1999/xlink"
               :xml:space "preserve"}
         elems]))

(defn label
  [l]
  (html [:text {:x "112"
                :y "52"
                :width "88px"
                :style "font-family: Helvetica; font-size: 36px; fill: #3e3e3e;"}
         l]))

(defn outline
  [width]
  (html [:rect {:x "0"
                :y "0"
                :width (str width "px")
                :height "78px"
                :style "stroke: #979797; stroke-width: 0.5; fill: none;"}]))
