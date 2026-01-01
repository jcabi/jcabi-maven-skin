/**
 * SPDX-FileCopyrightText: Copyright (c) 2012-2026 Yegor Bugayenko
 * SPDX-License-Identifier: MIT
 */

import com.jcabi.matchers.XhtmlMatchers
import com.jcabi.w3c.ValidatorBuilder
import groovy.xml.XmlParser
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers

MatcherAssert.assertThat(
    new File(basedir, 'build.log').text,
    Matchers.not(Matchers.containsString('ERROR'))
)

[
    'basics-child/target/site/index.html',
    'basics-child/target/site/css/jcabi.css',
].each {
    def file = new File(basedir, it)
    if (!file.exists()) {
        throw new IllegalStateException(
            "file ${file} doesn't exist"
        )
    }
}

def html = new File(basedir, 'target/site/index.html').text
def version = new XmlParser().parse(new File(basedir, 'pom.xml')).version.text()
MatcherAssert.assertThat(
    html,
    XhtmlMatchers.hasXPaths(
        '//xhtml:head/xhtml:link[@rel="shortcut icon"]',
        '//xhtml:body',
        "//xhtml:div[contains(.,'${version}')]",
        '//xhtml:div[contains(.,"test-org-name")]'
    )
)

def htmlResponse = new ValidatorBuilder().html().validate(html)
/**
 * If you use <<<fixed width font>>> in index.apt.vm, this test will fail.
 * Reason: maven-site-plugin doesn't create clean html5.
 * E.g. It renders <<< >>> as <tt>, which is obsolete and treated as an error.
 */
MatcherAssert.assertThat(
    "There are errors in:\n${html}",
    htmlResponse.errors(),
    Matchers.describedAs(htmlResponse.toString(), Matchers.hasSize(0))
)

// def cssResponse = new ValidatorBuilder().css().validate(
//     new File(basedir, 'target/site/css/jcabi.css').text
// )
// MatcherAssert.assertThat(
//     cssResponse.valid(),
//     Matchers.describedAs(cssResponse.toString(), Matchers.is(true))
// )
