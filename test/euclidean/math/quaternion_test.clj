(ns euclidean.math.quaternion
  (:require [clojure.test :refer :all]
            [euclidean.math.quaternion :as q]))

(deftest test-data-readers
  (is (= (pr-str (q/quaternion 1 2 3 4))
         "#math/quaternion [1.0 2.0 3.0 4.0]")))

(deftest test-equality
  (is (= (q/quaternion 1 2 3 4) (q/quaternion 1 2 3 4)))
  (is (not= (q/quaternion 1 2 3 4) (q/quaternion 1 2 4 5))))

(deftest test-lookup
  (let [q (q/quaternion 1 2 3 4)]
    (is (= (get q 0) 1.0))
    (is (= (q 3) 4.0))))

(deftest test-mult
  (let [q1 (q/quaternion 0.707 0 0 0.707)
        q2 (q/quaternion 0 -0.707 0 0.707)]
    (is (= (q/mult q1 q2)
           (q/quaternion 0.49984899999999993 -0.49984899999999993
                         -0.49984899999999993 0.49984899999999993)))))
