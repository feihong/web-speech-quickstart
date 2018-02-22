(ns demo.views
  (:require [re-frame.core :as re-frame]
            [demo.subs :as subs]
            [demo.events :as events]))


(defn main-panel []
  [:div.re-frame
   [:h2 "This is in re-frame"]
   [:button.button {:on-click #(re-frame/dispatch [::events/say-something])}
                   "Say something"]])
