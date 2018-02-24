(ns demo.events
  (:require [re-frame.core :as rf :refer [trim-v]]
            [demo.db :as db]))

(defn speak [phrase]
  (.speak js/speechSynthesis (js/SpeechSynthesisUtterance. phrase)))

(rf/reg-fx
  ::speak
  (fn [phrase]
    (speak phrase)))

(rf/reg-event-db
 ::initialize-db
 (fn  [_ _]
   db/default-db))

(rf/reg-event-fx
  ::say-something
  (fn [cofx [_ value]]
    {::speak value}))

(rf/reg-event-db
  ::say-another-thing
  [:trim-v]
  (fn [db _]
    (speak "I'm giving up on you")
    db))
