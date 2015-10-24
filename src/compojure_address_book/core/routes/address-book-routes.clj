(ns compojure-address-book.core.routes.address-book-routes
  (:require [compojure.core :refer [defroutes GET POST]]
            [address-book.core.views.address-book-layout :refer [common-layout]]))

(defn handle-post
  [request]
  (let [body (get-in request [:params :example-post])]
    (str "You posted: " body)))

(defn example-get [r])

(defn address-book-routes
  (GET "/" [] "Example GET")
  (POST "/post" [] handle-post))
