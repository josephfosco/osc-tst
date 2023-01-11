(ns osc-tst.core
  (:require [overtone.osc]
            [osc-tst.osc.connection]
            ))

(defn sc-connect
  (osc-tst.osc.connection/connect)
   )
