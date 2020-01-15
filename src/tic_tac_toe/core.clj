(ns tic-tac-toe.core)

(def symbols [:X :O])

(defn get-player [sym]
  (hash-map :name (read-line) :symbol sym))

(defn get-players [symbols]
  (doall (map get-player symbols)))

(defn draw-board [board] (println board))

(defn update-board [board move sym]
  (assoc board (Integer/parseInt move) sym))

(defn start-game
  [board-size]
  (let [players (get-players symbols)]
    (loop [current-player (first players)
           board (vec (repeat board-size " "))]
      (draw-board board)
      (recur
        (first (filter #(not= % current-player) players))
        (update-board board (read-line) (:symbol current-player))))))
