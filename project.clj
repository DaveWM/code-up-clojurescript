(defproject code-up-clojurescript "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/clojurescript "1.10.520"]
                 [reagent "0.8.1"]]

  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-figwheel "0.5.18"]
            [lein-doo "0.1.10"]]

  :clean-targets ^{:protect false}
[:target-path
 [:cljsbuild :builds :app :compiler :output-dir]
 [:cljsbuild :builds :app :compiler :output-to]]

  :resource-paths ["public"]

  :figwheel {:http-server-root "."
             :nrepl-port 7002
             :nrepl-middleware [cider.piggieback/wrap-cljs-repl]
             :css-dirs ["public/css"]}

  :doo {:paths {:karma "./node_modules/karma/bin/karma"}}

  :cljsbuild {:builds {:app
                       {:source-paths ["src" "env/dev/cljs"]
                        :compiler
                        {:main "code-up-clojurescript.dev"
                         :output-to "public/js/app.js"
                         :output-dir "public/js/out"
                         :asset-path "js/out"
                         :source-map true
                         :optimizations :none
                         :pretty-print true}
                        :figwheel
                        {:on-jsload "code-up-clojurescript.core/mount-root"
                         :open-urls ["http://localhost:3449/index.html"]}}
                       :devcards
                       {:id "devcards"
                        :source-paths ["src" "devcards"]
                        :figwheel {:devcards true
                                   :open-urls ["http://localhost:3450/cards.html"]}
                        :compiler {:main "code-up-clojurescript/devcards/core"
                                   :asset-path "js/devcards_out"
                                   :output-to "public/js/code_up_clojurescript_devcards.js"
                                   :output-dir "public/js/devcards_out"
                                   :source-map-timestamp true}}
                       :release
                       {:source-paths ["src" "env/prod/cljs"]
                        :compiler
                        {:output-to "public/js/app.js"
                         :output-dir "public/js/release"
                         :optimizations :advanced
                         :infer-externs true
                         :pretty-print false}}
                       :test
                       {:id "test"
                        :source-paths ["src" "test"]
                        :compiler {:output-to "public/js/testable.js"
                                   :output-dir "public/js/tests_out"
                                   :asset-path "public/js/tests_out"
                                   :main code-up-clojurescript.runner
                                   :optimizations :none}}}}

              :aliases {"package" ["do" "clean" ["cljsbuild" "once" "release"]]
                        "devcards" ["with-profile" "+devcards" "figwheel" "devcards"]}

              :profiles {:dev {:source-paths ["src" "env/dev/clj"]
                               :dependencies [[binaryage/devtools "0.9.10"]
                                              [figwheel-sidecar "0.5.18"]
                                              [nrepl "0.6.0"]
                                              [cider/piggieback "0.4.0"]
                                              [devcards "0.2.6"]]}
                         :devcards {:figwheel {:server-port 3450
                                               :nrepl-port 7001}
                                    :source-paths ["src" "devcards"]}})
