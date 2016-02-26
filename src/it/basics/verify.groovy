/**
 * Copyright (c) 2012-2015, jcabi.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met: 1) Redistributions of source code must retain the above
 * copyright notice, this list of conditions and the following
 * disclaimer. 2) Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution. 3) Neither the name of the jcabi.com nor
 * the names of its contributors may be used to endorse or promote
 * products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import com.jcabi.matchers.XhtmlMatchers
import com.jcabi.w3c.ValidatorBuilder
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers

MatcherAssert.assertThat(
    new File(basedir, 'build.log').text,
    Matchers.not(Matchers.containsString('ERROR'))
)

[
    'basics-child/target/site/index.html',
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
    htmlResponse.errors(),
    Matchers.describedAs(htmlResponse.toString(), Matchers.hasSize(0))
)
/**
 * The check for no warnings was removed since there were warnings about
 * rendered elements which had unnecessary attributes. However, Doxia (used by
 * maven-site-plugin) does not offer such granular control over what is
 * rendered (see https://maven.apache.org/doxia/references/doxia-apt.html).
 * The alternative would be to have a very light test, almost irrelevant,
 * with an almost empty index.apt.vm, or a very complicated one to disregard
 * warnings related to attributes, which come in more than just 1 pattern.
 */

def cssResponse = new ValidatorBuilder().css().validate(
    new File(basedir, 'target/site/css/jcabi.css').text
)
MatcherAssert.assertThat(
    cssResponse.valid(),
    Matchers.describedAs(cssResponse.toString(), Matchers.is(true))
)
