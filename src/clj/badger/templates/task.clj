(ns badger.templates.task
  (:require [hiccup.core :refer [html h]]
            [hiccup.page :refer [xml-declaration]]
            [badger.templates.base :refer [label outline svg]]))

(defn- width
  [n]
  (-> (count n)
      (- 1)
      (* 24)
      (+ 288)))

; This is super hacky and should be
; pulled out into its own equation.
; My brain is totally fried and
; is struggling to come up with the
; best fit.

(defn- constant
  [n]
  (case (count n)
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

(defn template
  [n]
  (let [n (h n)
        width (str (width n) "px")]
    (html (xml-declaration "UTF-8")
          (svg width
           [:image {:x "12"
                    :y "12"
                    :width "88px"
                    :height "54px"
                    :xlink:href "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFgAAAA2CAYAAABDa14eAAADLUlEQVR4nO3cv2sTYRzH8fcdQhBBORF0d3KtbSN0PdOctmggk0sGHSXYHw5Fa9P6gyC1rYGCi0pAECRwttbmLLdmiNWIo+Bf4HLSotCpDpeE6mDzPHfJJe3zGgvf733uoflxz/cuGnVGsTwMTAD9gEH0POAzsOBlrHKgRmkzCYzT3nNr5H1ilFyn8UcNwCiWZ4Bcmw4chodexrorU+ilzTlgOuQ8+3lglNxpAM0olpNAoP+QDhn1MtaaSIGXNi1gvU159jNqlNw1HRiLKICocYmaKM9tHEAHLkQYQsSARE1/6ClaNwD+AvcKrUM1YdHAX+BqhCFEbErUfAo9Res2wV/gpQhDiJDJGeW5LQLoXsZaB+YiDNKKx17GWhEtMkrue+B+G/LsJ2+U3FXY8x5lFMuX8T/54sCxCEL96xf+y+ypl7HeBmnkpc0R/HMbpH3n1sxrlNxAeRVFURRFURRFURRFUWQ1N3sKG0PDwCT+TvyJyBLJ2aK+0ZJNVN4FaWQmU7LrsF3PUHAdu7nzpwEUNoZywEyQYF3kUTZRuSNTaCZTOcJZh7zr2FMAWmFjKMrJa7tcySYqqyIFZjIV9nT9quvYKzpwK8Sm3UJmAj0ZcoYx6K2psohumEAPQm9NlUVEOU3+Sy9NlUV0wwT6I/gLvBhy426wIFEzH3IGf6qcTVTKwGzIzaOUzyYqwhNo17EdwluHfOO78N4LDQv/9tUB4HhIB+qUbfyX+JLo17N/hX2hoSiKoiiKoiiKoiiK0knNzZ76TOo2/oRDB74Cy8Ar17F3ZQ+wU+07B9wDTOBUoLTd7zf+/vp8LF5bh/oC7zNNfQlcl1nknWrfCPAGOCqTtsfNxuK1nGYmU61MlW+6jr0s0n2n2nca+Ebv3WMRpks6rU1TZZ75vcHhXlyACZ3WpqlnzWTqpGDz8xKBDpp+kamy6Huw9AfjAbKr09oE9rvr2J5g8yifE+4WmzqtTVNlprTPgZ8SdQfJgl6fpv7vhrcXwDPRzrF47QdwDf8R08MoF4vXnL0XGo0fRYoDR4AvwLLr2K+DHKV+oTEFXATOBOnVA7bwbziZj8VrHwD+ACz7z6tWbb+iAAAAAElFTkSuQmCC"}]
           (label "Tasks")
           [:g
            [:rect {:x "224"
                    :y "0"
                    :width "100%"
                    :height "78px"
                    :style "fill: #3e3e3e"}]
            [:text {:x (text-offset n)
                    :y "52"
                    :text-anchor "middle"
                    :width "100%"
                    :style "font-family: Courier; font-size: 42px; fill: #f0f0f0"}
             n]]
            (outline width)))))
