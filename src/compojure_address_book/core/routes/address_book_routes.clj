(ns compojure-address-book.core.routes.address-book-routes
  (:require [compojure.core :refer [defroutes GET POST]]
            [compojure-address-book.core.views.address-book-layout :refer [common-layout]]))

(defn handle-post
  [request]
  (let [body (get-in request [:params :example-post])]
    (str "You posted: " body)))

(defn example-get [request]
  (common-layout
    [:p "Example GET"])
  )
(defroutes address-book-routes
  (GET "/" [] example-get)
  (POST "/post" [] handle-post))
