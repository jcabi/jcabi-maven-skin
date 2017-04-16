<img src="http://img.jcabi.com/logo-square.png" width="64px" height="64px" />

[![Made By Teamed.io](http://img.teamed.io/btn.svg)](http://www.teamed.io)
[![DevOps By Rultor.com](http://www.rultor.com/b/jcabi/jcabi-maven-skin)](http://www.rultor.com/p/jcabi/jcabi-maven-skin)

[![Build Status](https://travis-ci.org/jcabi/jcabi-maven-skin.svg?branch=master)](https://travis-ci.org/jcabi/jcabi-maven-skin)
[![PDD status](http://www.0pdd.com/svg?name=jcabi/jcabi-maven-skin)](http://www.0pdd.com/p?name=jcabi/jcabi-maven-skin)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.jcabi/jcabi-maven-skin/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.jcabi/jcabi-maven-skin)

More details are here: [skin.jcabi.com](http://skin.jcabi.com/index.html)

Use it in your `site.xml`, as explained in
[skinning](http://maven.apache.org/plugins/maven-site-plugin/examples/sitedescriptor.html#Skinning):

```xml
<project>
  [...]
  <skin>
    <groupId>com.jcabi</groupId>
    <artifactId>jcabi-maven-skin</artifactId>
  </skin>
  [...]
</project>
```

Don't forget to install `fontcustom` Ruby gem:

On Linux/OS X it would be something like:

```
$ sudo gem install fontcustom
```



## Questions?

If you have any questions about the framework, or something doesn't work as expected,
please [submit an issue here](https://github.com/jcabi/jcabi-maven-skin/issues/new).

## How to contribute?

Fork the repository, make changes, submit a pull request.
We promise to review your changes same day and apply to
the `master` branch, if they look correct.

Please run Maven build before submitting a pull request:

```
$ mvn clean install -Pqulice
```

Make sure you have Maven 3.2+, Java7+ and
[fontcustom](http://fontcustom.com/) gem installed.
