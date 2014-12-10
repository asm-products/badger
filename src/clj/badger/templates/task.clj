(ns badger.templates.task
  (:require [hiccup.core :refer [html h]]
            [hiccup.page :refer [xml-declaration]]
            [badger.templates.base :refer [label outline svg]]))

(defn- width
  [n]
  (-> (count n)
      (- 1)
      (* 24)
      (+ 328)))

; This is super hacky and should be
; pulled out into its own equation.
; My brain is totally fried and
; is struggling to come up with the
; best fit.

(defn- constant
  [n]
  (case (count n)
    0 32
    1 32
    2 22
    3 19
    4 17
    5 16
    6 15.5
    7 15
    8 14.5
    9 14.1
    10 13.9
    11 13.7))

(defn- text-offset
  [n]
  (- (width n) (* (count n) (constant n))))

(defn- custom-image-scale-factor []
  (/ 54 433.2))

(defn template
  [n]
  (let [n (h n)
        width (width n)]
    (html (svg width 24
            [:g {
              :transform (str "scale(" (custom-image-scale-factor) ") translate(" (/ 12 (custom-image-scale-factor)) " " (/ 12 (custom-image-scale-factor)) ")")
            }
              [:path {
                :fill "#14A2B7"
                :d "M304.9,80.2H40.1C17.9,80.2,0,62.2,0,40.1S17.9,0,40.1,0h264.8C327,0,345,17.9,345,40.1S327,80.2,304.9,80.2z"
              }]
              [:path {
                :fill "#F15745"
                :d "M658,80.2H481.4c-22.1,0-40.1-17.9-40.1-40.1S459.3,0,481.4,0H658C680.1,0,698,17.9,698,40.1S680.1,80.2,658,80.2z"
              }]
              [:path {
                :fill "#93BC3F"
                :d "M393.2,256.7H40.1C17.9,256.7,0,238.8,0,216.6s17.9-40.1,40.1-40.1h353.1c22.1,0,40.1,17.9,40.1,40.1S415.3,256.7,393.2,256.7z"
              }]
              [:path {
                :fill "#454A52"
                :d "M658,256.7h-88.3c-22.1,0-40.1-17.9-40.1-40.1s17.9-40.1,40.1-40.1H658c22.1,0,40.1,17.9,40.1,40.1S680.1,256.7,658,256.7z"
              }]
              [:path {
                :fill "#FACB34"
                :d "M658,433.2H216.6c-22.1,0-40.1-17.9-40.1-40.1c0-22.1,17.9-40.1,40.1-40.1H658c22.1,0,40.1,17.9,40.1,40.1C698,415.3,680.1,433.2,658,433.2z"
              }]
              [:circle {
                :fill "#454A52"
                :cx "40.1"
                :cy "393.2"
                :r "40.1"
              }]
            ]
           (label "Bounties")
           [:g
            [:rect {:x "264"
                    :y "0"
                    :width (- width 264)
                    :height "78px"
                    :style "fill: #3e3e3e"}]
            [:text {:x (text-offset n)
                    :y "52"
                    :text-anchor "middle"
                    :style "font-family: Courier; font-size: 42px; fill: #f0f0f0"}
             n]]
            (outline width)))))
