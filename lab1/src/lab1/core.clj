(ns lab1.core
  (:gen-class))

(def letters ["a", "b", "c"])
(def n 4)
(def proc [])
(def startString [["a"], ["b"], ["c"]])
(def testStrings [["a", "b", "c"], ["a", "b", "c"], ["a", "b", "b"], ["a", "b", "a"]])

(defn compareStrings [str1, str2]
  (not= 0 (compare (last str1) str2))
)

(defn filterPreviousStrings [prev, letter]
  (filter (fn [curStr] (compareStrings curStr letter)) prev)
)

(defn concatFilteredStringsWithLetter [prev, letter]
  (map (fn [curStr] (conj curStr letter)) prev)
)

(defn getStringsFromPreviousStrings [prev, letters]
  (mapcat concat (map (fn [letter] (concatFilteredStringsWithLetter (filterPreviousStrings prev letter) letter)) letters))
)

(defn generateStringsOfLength [prev, letters, n, len]
  (if (< len n) 
    (generateStringsOfLength (getStringsFromPreviousStrings prev letters) letters n (inc len)) 
    prev
  )
)

(defn generateStrings [letters, n]
  (generateStringsOfLength startString letters n 1)
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (generateStrings letters n))
  ; (println (mapcat concat (getStringsFromPreviousStrings testStrings letters)))
  ; (println (getStringsFromPreviousStrings testStrings, letters))
  ; (println (concatFilteredStringsWithLetter (filterPreviousStrings testStings "b") "b"))
  ; (println (compareStrings ["a", "b", "c"] "c"))
  )