(ns main.index
  (:require
   [hoplon.core  :as h]
   [javelin.core :as j :refer [cell cell=]]
   [hoplon.jquery]
   [hoplon.svg :as svg]
   ))





(defn my-list [& items]
  (h/div
    :class "my-list"
    (apply h/ul (map #(h/li (h/div :class "my-list-item" %)) items))))


(def clicks (cell 0))


(def home
  (h/div :id "app"
         ;; (svg/svg :class "bg-green-500" :id "slopegraph")
         (h/div :class "bg-green-200" "This is just some text")
         (h/div :class "text-gray-700" (h/nav
                                         (h/h1
                                           (h/a :href "/" "HOME")))

                (my-list
                  (h/a :href "#" (h/span "List 1"))
                  (h/a :href "#" (h/span "List 2")))


                (h/main

                  (h/header
                    (h/h1 :class "text-gray-700 text-6xl" "SOME TITLE")
                    (h/h3 "A sub heading")))

                (h/h4 "Title for the graph")
                (h/div :id "slopegraph")


                (svg/svg :id "haran" :height 20 :width 20 (svg/circle :cx 10 :cy 10 :r 10 :fill "red"))


                (h/p (h/text "You've clicked ~{clicks} times, so far."))
                (h/button :click #(swap! clicks inc) "click me"))))


(defn init! []
  (let [app    (.getElementById js/document "app")
        parent (.-parentElement app)]
    (.replaceChild parent (home) app)))


(defn ^{:export true} main []
  (init!))


