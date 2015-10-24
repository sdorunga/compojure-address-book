(ns compojure-address-book.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [compojure-address-book.handler :refer :all]))

(deftest test-app
  (testing "Test GET"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (.contains (:body response) "Example GET"))))
  (testing "Test POST"
    (let [response (app (mock/request :post "/post" {:example-post "Some data"}))]
      (is (= (:status response) 200))
      (is (= (:body response) "You posted: Some data"))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
