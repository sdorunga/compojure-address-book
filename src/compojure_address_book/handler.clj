(ns compojure-address-book.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [compojure-address-book.core.routes.address-book-routes :refer [address-book-routes]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defn init []
  (println "Address book application is starting"))

(defroutes app-routes
  (route/not-found "Not Found"))

(def app
  (-> (routes address-book-routes app-routes)
      (wrap-defaults (assoc-in site-defaults [:security :anti-forgery] false))))
