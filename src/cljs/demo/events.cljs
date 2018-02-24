(ns demo.events
  (:require [re-frame.core :as rf :refer [trim-v]]
            [demo.db :as db]))

(rf/reg-event-db
 ::initialize-db
 (fn  [_ _]
   db/default-db))

(defn speak [phrase]
  (.speak js/speechSynthesis (js/SpeechSynthesisUtterance. phrase)))

(rf/reg-event-db
  ::say-something
  (fn [db _]
    (speak "Say something now")
    db))

(rf/reg-event-db
  ::say-another-thing
  [:trim-v]
  (fn [db _]
    (speak "I'm giving up on you")
    db))
