# OSC-clj Changelog

## 0.9.0
_17th January 2013_

* Allow nesting of calls to `in-osc-bundle` to create nested bundles
* Add `in-unested-osc-bundle` to allow for the creation of bundles which are sent immediately and aren't nested in any outer bundle
* Teach peers to disable support for nesting bundles when sending OSC messages (some servers, such as the SuperCollider server don't support them)
* Update dependency on JMDNS to 3.4.1
* Update dependency on at-at to 1.1.1

## 0.8.1
_21st Aug 2012_

* Fixed `osc-recv` to return the message, not the peer.
* Added the ability to handle exceptions wrapped in RuntimeException
  which aren't correctly unwrapped in Clojure 1.3 (this may be removed
  in the future).

## 0.8.0
_26th June 2012_

* Added `without-osc-bundle` to allow specific OSC messages generated
  within a call to `in-osc-bundle` to pass through unbundled. Likely to
  be rarely used. Prefer not using this unless explicitly required.
* Type hint message sending aspects of code for faster performance
* Wait for longer before timing out the send operation
* Increase size of initial send queue
* Updated dependency on `at-at` to 1.0.0
* Add `osc-reply-msg` and `osc-reply`
* Improve client print-method
* Fix race condition between socket bind and receive
