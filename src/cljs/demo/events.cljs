(ns demo.events
  (:require [re-frame.core :as re-frame]
            [demo.db :as db]))

(re-frame/reg-event-db
 ::initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/reg-event-db
  ::say-something
  (fn [db _]
    (.speak js/speechSynthesis (js/SpeechSynthesisUtterance. "Say something now"))
    db))
