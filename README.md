play-livescript
===============

Rudimentary [LiveScript 1.2.0] [1] asset handling for [Play 2.2.x] [2], implemented as an [sbt] [3]
plugin (very similar to Play's handling of CoffeeScript and LESS), working very similarly to CoffeeScript

How to Use
----------

A fake ivy repository is now available on github for easier installation. Add the following to your `plugins.sbt`:

```scala
resolvers += Resolver.url("Objectify Play Repository", url("https://github.com/SunPj/ivy/raw/master"))(Resolver.ivyStylePatterns)

addSbtPlugin("com.github.otfoo" % "play-livescript" % "0.1")
```

If something doesn't work, open an issue and I'll get around to it.

License
-------

MIT-style licensing, for details see file LICENSE.

[1]: http://learnboost.github.com/stylus/
[2]: http://www.playframework.org/
[3]: https://github.com/harrah/xsbt
[4]: https://github.com/patiencelabs/play-stylus