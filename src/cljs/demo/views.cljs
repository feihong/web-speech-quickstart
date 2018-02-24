(ns demo.views
  (:require [re-frame.core :as rf]
            [demo.subs :as subs]
            [demo.events :as events]))


(defn main-panel []
  [:div.re-frame
   [:h2 "Rendered by re-frame"]
   [:div.field.is-grouped
    [:p.control
     [:button.button.is-rounded.is-primary
      {:on-click #(rf/dispatch [::events/say-something])}
      "Simple dispatch"]]
    [:p.control
     [:button.button.is-rounded.is-info
      {:on-click #(rf/dispatch [::events/say-another-thing])}
      "Dispatch with interceptor"]]]])
