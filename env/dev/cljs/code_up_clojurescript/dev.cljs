(ns ^:figwheel-no-load code-up-clojurescript.dev
  (:require
    [code-up-clojurescript.core :as core]
    [devtools.core :as devtools]))


(enable-console-print!)

(devtools/install!)

(core/init!)
