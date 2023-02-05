(ns osc-tst.core
  (:use [osc-tst.config]
        [sc-osc.connection]
        [sc-osc.event]
        [sc-osc.server-comms]
        ))

(defn sc-connect
  []
  (connect)
   )

(defn synth-file
  [fname]
  (str SYNTH-DIR fname SYNTHDEF-FILE-EXT)
  )
