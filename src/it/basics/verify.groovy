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
import java.util.Calendar

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
def doc = Jsoup.parse(html)
doc.outputSettings().syntax(Document.OutputSettings.Syntax.xml)
def xhtml = doc.html()
def version = new XmlParser().parse(new File(basedir, 'pom.xml')).version.text()
def year = Calendar.getInstance().get(Calendar.YEAR).toString()
MatcherAssert.assertThat(
    xhtml,
    XhtmlMatchers.hasXPaths(
        '//xhtml:head/xhtml:link[@rel="shortcut icon"]',
        '//xhtml:body',
        "//xhtml:div[contains(.,'${version}')]",
        '//xhtml:div[contains(.,"test-org-name")]',
        '//xhtml:footer[@class="legal-notes"]',
        "//xhtml:footer[contains(.,'-${year}')]"
    )
)
MatcherAssert.assertThat(
    "footer must not contain unresolved velocity variable",
    xhtml,
    Matchers.not(
        Matchers.anyOf(
            Matchers.containsString('${currentYear}'),
            Matchers.containsString('$date.format')
        )
    )
)
