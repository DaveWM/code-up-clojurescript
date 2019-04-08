(ns code-up-clojurescript.core-test
  (:require [clojure.test :refer-macros [deftest is]]
            [code-up-clojurescript.core]))

(deftest foo
  (is (= "bar" "bar")))
