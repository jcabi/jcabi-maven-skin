<img src="http://img.jcabi.com/logo.png" width="200px" height="48px" />

More details are here: [skin.jcabi.com](http://skin.jcabi.com/index.html)

Use it in your `site.xml`, as explained in
[skinning](http://maven.apache.org/plugins/maven-site-plugin/examples/sitedescriptor.html#Skinning):

```xml
<project>
  [...]
  <skin>
    <groupId>com.jcabi</groupId>
    <artifactId>jcabi-maven-skin</artifactId>
    <version>1.0</version>
  </skin>
  [...]
</project>
```

## Questions?

If you have any questions about the framework, or something doesn't work as expected,
please [submit an issue here](https://github.com/jcabi/jcabi-maven-skin/issues/new).
If you want to discuss, please use our [Google Group](https://groups.google.com/forum/#!forum/jcabi).

## How to contribute?

Fork the repository, make changes, submit a pull request.
We promise to review your changes same day and apply to
the `master` branch, if they look correct.

Please run Maven build before submitting a pull request:

```
$ mvn clean install -Pqulice
```
