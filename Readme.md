Euclid [![Build Status (Travis)][badge-travis]][build-travis] [![Build Status (Appveyor)][badge-appveyor]][build-appveyor]
======

Euclid will be a UI framework for terminal environments, like actual desktop
terminal emulator or [rot.js][rot-js]. 

Build
-----

To build the project (just a stub for now), install [SBT][sbt] and then execute
the following command in your terminal:

```console
$ sbt compile
```

Test
----

To execute the automatic test suite, run the following command in your terminal:

```console
$ sbt test
```

Run
---

To run the manual test projects (just stubs for now) for JVM and Scala.js,
execute the following commands in your terminal:

```console
$ sbt 'project euclidJVM' run
$ sbt 'project euclidJS' run
```

[build-appveyor]: https://ci.appveyor.com/project/ForNeVeR/euclid/branch/master
[build-travis]: https://travis-ci.org/codingteam/euclid
[rot-js]: http://ondras.github.io/rot.js/hp/
[sbt]: http://www.scala-sbt.org/

[badge-appveyor]: https://ci.appveyor.com/api/projects/status/gr42tg6db572jts6/branch/master?svg=true
[badge-travis]: https://travis-ci.org/codingteam/euclid.svg?branch=master
