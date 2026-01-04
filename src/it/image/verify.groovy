/**
 * SPDX-FileCopyrightText: Copyright (c) 2012-2026 Yegor Bugayenko
 * SPDX-License-Identifier: MIT
 */

import com.jcabi.matchers.XhtmlMatchers
import groovy.xml.XmlParser
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

MatcherAssert.assertThat(
    "We shouldn't have any errors",
    new File(basedir, 'build.log').text,
    Matchers.not(Matchers.containsString('ERROR'))
)

def html = new File(basedir, 'target/site/index.html').text
def doc = Jsoup.parse(html)
doc.outputSettings().syntax(Document.OutputSettings.Syntax.xml)
def xhtml = doc.html()
def version = new XmlParser().parse(new File(basedir, 'pom.xml')).version.text()
MatcherAssert.assertThat(
    "HTML must contain banner image",
    xhtml,
    XhtmlMatchers.hasXPaths(
        '//xhtml:img[@src="../../favicon.ico"]'
    )
)
