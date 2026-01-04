# Universal Maven Skin

[![EO principles respected here](https://www.elegantobjects.org/badge.svg)](https://www.elegantobjects.org)
[![DevOps By Rultor.com](http://www.rultor.com/b/jcabi/jcabi-maven-skin)](http://www.rultor.com/p/jcabi/jcabi-maven-skin)

[![mvn](https://github.com/jcabi/jcabi-maven-skin/actions/workflows/mvn.yml/badge.svg)](https://github.com/jcabi/jcabi-maven-skin/actions/workflows/mvn.yml)
[![PDD status](http://www.0pdd.com/svg?name=jcabi/jcabi-maven-skin)](http://www.0pdd.com/p?name=jcabi/jcabi-maven-skin)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.jcabi/jcabi-maven-skin/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.jcabi/jcabi-maven-skin)

More details are here: [skin.jcabi.com](http://skin.jcabi.com/index.html).

Use it in your `site.xml`, as explained in [skinning]:

```xml
<site>
  [...]
  <skin>
    <groupId>com.jcabi</groupId>
    <artifactId>jcabi-maven-skin</artifactId>
    <version>0.0.0</version>
  </skin>
  [...]
</site>
```

## How to contribute?

Fork the repository, make changes, submit a pull request.
We promise to review your changes same day and apply to
the `master` branch, if they look correct.

Please run Maven build before submitting a pull request:

```bash
mvn clean install -Pqulice
```

Make sure you have Maven 3.2+, Java7+ and
[fontcustom](http://fontcustom.com/) gem installed.

[skinning]: http://maven.apache.org/plugins/maven-site-plugin/examples/sitedescriptor.html#Skinning
