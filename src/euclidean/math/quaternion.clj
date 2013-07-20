(ns euclidean.math.quaternion)

(definterface Coords4D
  (^double getX [])
  (^double getY [])
  (^double getZ [])
  (^double getW []))

(deftype Quaternion [^double x ^double y ^double z ^double w]
  Coords4D
  (getX [_] x)
  (getY [_] y)
  (getZ [_] z)
  (getW [_] w)

  clojure.lang.Counted
  (count [_] 4)

  clojure.lang.Sequential

  clojure.lang.Seqable
  (seq [_] (list x y z w))

  clojure.lang.ILookup
  (valAt [q i]
    (.valAt q i nil))
  (valAt [_ i not-found]
    (case i 0 x 1 y 2 z 3 w not-found))

  clojure.lang.IFn
  (invoke [q i]
    (.valAt q i))

  Object
  (toString [_]
    (str "#math/quaternion [" x " " y  " " z " " w "]"))
  (equals [_ q]
    (and (= (count q) 4)
         (= x (q 0))
         (= y (q 1))
         (= z (q 2))
         (= w (q 3)))))

(defn mult
  "Multiply two quaternions together."
  [^Quaternion q1 ^Quaternion q2]
  (let [x1 (.getX q1), y1 (.getY q1), z1 (.getZ q1), w1 (.getW q1)
        x2 (.getX q2), y2 (.getY q2), z2 (.getZ q2), w2 (.getW q2)]
    [(+ (* x1 w2)     (* y1 z2)     (- (* z1 y2)) (* w1 x2))
     (+ (- (* x1 z2)) (* y1 w2)     (* z1 x2)     (* w1 y2))
     (+ (* x1 y2)     (- (* y1 x2)) (* z1 w2)     (* w1 z2))
     (+ (- (* x1 x2)) (- (* y1 y2)) (- (* z1 z2)) (* w1 w2))]))

(defn quaternion [^double x ^double y ^double z ^double w]
  (Quaternion. x y z w))

(defn into-quaternion [coll]
  (apply quaternion coll))

(defmethod print-method Quaternion [^Quaternion q ^java.io.Writer w]
  (.write w (.toString q)))
