/**
 * Copyright (c) 2012-2021, jcabi.com
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
 * 'AS IS' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT
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

/*globals $:false, window:false */

$(document).ready(
    function () {
        $('.menu-button').click(
            function() {
                if ($('#here-goes-menu').attr('class') === 'menu-off') {
                    $('#menu').clone().attr('class', 'mobile-menu').appendTo('#here-goes-menu');
                    $('#here-goes-menu').attr('class', 'menu-on');
                } else {
                    $('.mobile-menu').hide();
                    $('#here-goes-menu').attr('class', 'menu-off');
                }
            }
        );
        $('a.ico').click(
            function (event) {
                event.preventDefault();
                var $this = $(this);
                window.open(
                    $this.attr('href'),
                    $this.attr('title'),
                    'width=640,height=300'
                );
            }
        );
        $('a.ico').each(
            function () {
                this.href = this.href.replace('URL', encodeURIComponent(window.location));
                this.href = this.href.replace('TITLE', encodeURIComponent($(document).find('title').text()));
            }
        );
    }
);
