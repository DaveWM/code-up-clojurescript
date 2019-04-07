(ns code-up-clojurescript.devcards.core
  (:require [devcards.core :as dc :include-macros true]
            [code-up-clojurescript.core :as core])
  (:require-macros
    [devcards.core :refer [defcard]]))

(defcard home-page-card
  (dc/reagent core/home-page)
  nil
  {:inspect-data true :history true})


