(ns code-up-clojurescript.prod
  (:require
    [code-up-clojurescript.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
