2(ns osc-tst.core
  (:use [osc-tst.config]
        [sc-osc.sc]
        ))

(defn synth-file
  [fname]
  (str SYNTH-DIR fname SYNTHDEF-FILE-EXT)
  )
