(ns lab2.core
  (:gen-class))

; Create test function f(t)
; Derive step from [0, x]
; Make target function without memoization
; Make target function with memoization

; Test target function
(defn f [t] (* t t))

; Split X area into peaces
(def steps 10000)
(defn getStep [x] (/ x steps))

; Get Xs
(defn getAreas [x]
  (map (fn [curStep] (* (getStep x) curStep)) (range 0 (- steps 1)))
)

; Get f values
(defn getFunctionValues [x]
  (map (fn [curAreaValue] (f curAreaValue)) (getAreas x))
)

(defn getFunctionsAverage [curAreaValue]
  (/ (+ (f (+ curAreaValue (getStep curAreaValue))) (f curAreaValue)) 2)
)

(defn countCurAreaValue [prevSum, curAreaValue, x] 
  (+ (* (getFunctionsAverage curAreaValue) (getStep x)) prevSum)
)

; Target function without memoization
(defn result [x]
  (reduce (fn [acc, curAreaValue]  (countCurAreaValue acc curAreaValue x)) 0 (getAreas x))
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (result 50.0))
  ; (println (getFunctionsAverage 10.0))
  ; (println (getStep 200)) - Correct
  ; (println (getAreas 1.0)) - Correct
  ; (println (f 100))
  )