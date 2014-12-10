(ns badger.templates.base
  (:require [hiccup.core :refer [html]]))

(defn svg
  [width height & elems]
  (html [:svg {:viewBox (str "0 0 " width " 78")
               :height (str height "px")
               :width (str width "px")
               :preserveAspectRatio "xMinYMin"
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
                :width (str width)
                :height "78px"
                :style "stroke: #979797; stroke-width: 0.5; fill: none;"}]))
