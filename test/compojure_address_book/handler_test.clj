(ns compojure-address-book.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [compojure-address-book.handler :refer :all]
            [compojure-address-book.core.routes.address-book-routes :refer [contacts]]))

(deftest test-app
  (testing "Test GET"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (.contains (:body response) "Jarrod Taylor"))
      (is (.contains (:body response) "Johnny Utah"))
      (is (.contains (:body response) "James Dalton"))))

  (testing "Test POST"
    (let [response (app (mock/request :post "/post" {:name "Joseph" :phone "1234" :email "josephstalin@cccp.com"}))
          new-contact (filter #(= 4 (:id %)) @contacts)]
      (is (= (:status response) 302))
      (is (= (:name (first new-contact)) "Joseph"))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
