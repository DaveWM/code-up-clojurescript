(ns code-up-clojurescript.runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [code-up-clojurescript.core-test]))

(doo-tests 'code-up-clojurescript.core-test)
