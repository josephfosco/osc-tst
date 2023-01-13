(ns osc-tst.core
  (:use [sc-osc.connection]
        ))

(defn sc-connect
  []
  (sc-osc.connection/connect)
   )
