# Euclidean

[![Build Status](https://travis-ci.org/weavejester/euclidean.png?branch=master)](https://travis-ci.org/weavejester/euclidean)

A Clojure library for performing calculations suitable for 3D games
using fast, immutable data structures.

Euclidean is written in pure Clojure, but has performance comparable
to vector libraries written in Java, such as [Vectorz][1].

[1]: https://github.com/mikera/vectorz-clj

## Installation

Add the following dependency to your `project.clj` file:

    [euclidean "0.1.7"]

## Example

```clojure
(require '[euclidean.math.vector :as v])
(require '[euclidean.math.quaternion :as q])

(q/rotate (q/yaw Math/PI) (v/vector 0 0 1))
```

## Documentation

* [API Docs](http://weavejester.github.io/euclidean/)

## License

Copyright © 2013 James Reeves

Distributed under the Eclipse Public License, the same as Clojure.
