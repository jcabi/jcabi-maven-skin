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
    "We shouldn't have any errors",
    new File(basedir, 'build.log').text,
    Matchers.not(Matchers.containsString('ERROR'))
)

def html = new File(basedir, 'target/site/index.html').text
def version = new XmlParser().parse(new File(basedir, 'pom.xml')).version.text()
MatcherAssert.assertThat(
    "HTML must contain favicon link, the link is relative to the site root",
    html,
    XhtmlMatchers.hasXPaths(
        '//xhtml:img[@src="../../favicon.ico"]',
    )
)

