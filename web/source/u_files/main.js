(function (a) {
    function d() {
        var f = a(".portfolio-grid"), e = a(".portfolio-filters");
        if (f) {
            f.shuffle({speed: 450, itemSelector: "figure"});
            e.on("click", ".filter", function (g) {
                f.shuffle("update");
                g.preventDefault();
                a(".portfolio-filters .filter").parent().removeClass("active");
                a(this).parent().addClass("active");
                f.shuffle("shuffle", a(this).attr("data-group"))
            })
        }
    }

    function c() {
        var f = a(window).width(), e = a("#site_header");
        if (f < 1025) {
            e.addClass("mobile-menu-hide");
            a(".menu-toggle").removeClass("open");
            setTimeout(function () {
                e.addClass("animate")
            }, 500)
        } else {
            e.removeClass("animate")
        }
    }

    function b() {
        var e = a(window).width();
        if (e > 1024) {
            a(".animated-section, .single-page-content").each(function () {
                a(this).perfectScrollbar()
            })
        } else {
            a(".animated-section, .single-page-content").each(function () {
                a(this).perfectScrollbar("destroy")
            })
        }
    }

    a(function () {
        a("#contact_form").validator();
        a("#contact_form").on("submit", function (f) {
            if (!f.isDefaultPrevented()) {
                var g = "contact_form/contact_form.php";
                a.ajax({
                    type: "POST", url: g, data: a(this).serialize(), success: function (h) {
                        var i = "alert-" + h.type;
                        var j = h.message;
                        var e = '<div class="alert ' + i + ' alert-dismissable"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>' + j + "</div>";
                        if (i && j) {
                            a("#contact_form").find(".messages").html(e);
                            a("#contact_form")[0].reset()
                        }
                    }
                });
                return false
            }
        })
    });
    a(window).on("load", function () {
        a(".preloader").fadeOut(800, "linear");
        var e = a(".animated-sections");
        if (e[0]) {
            PageTransitions.init({menu: "ul.main-menu",})
        }
    }).on("resize", function () {
        c();
        a(".animated-section").each(function () {
            a(this).perfectScrollbar("update")
        });
        b()
    });
    a(document).on("ready", function () {
        var h = 23;
        var g = h / a(document).height();
        var i = h / a(document).width();
        a("body").on("mousemove", function (j) {
            var n = j.pageX - (a(document).width() / 2), o = j.pageY - (a(document).height() / 2), l = i * n * -1,
                m = g * o * -1, k = a(".lm-animated-bg");
            k.addClass("transition");
            k.css({"background-position": "calc( 50% + " + l + "px ) calc( 50% + " + m + "px )",});
            setTimeout(function () {
                k.removeClass("transition")
            }, 300)
        });
        a(".menu-toggle").on("click", function () {
            a("#site_header").addClass("animate");
            a("#site_header").toggleClass("mobile-menu-hide");
            a(".menu-toggle").toggleClass("open")
        });
        a(".main-menu").on("click", "a", function (j) {
            c()
        });
        a(".sidebar-toggle").on("click", function () {
            a("#blog-sidebar").toggleClass("open")
        });
        var f = a(".portfolio-grid");
        f.imagesLoaded(function () {
            d(this)
        });
        var e = a(".blog-masonry");
        e.imagesLoaded(function () {
            e.masonry()
        });
        b();
        a(".text-rotation").owlCarousel({
            loop: true,
            dots: false,
            nav: false,
            margin: 0,
            items: 1,
            autoplay: true,
            autoplayHoverPause: false,
            autoplayTimeout: 3800,
            animateOut: "animated-section-scaleDown",
            animateIn: "animated-section-scaleUp"
        });
        a(".testimonials.owl-carousel").owlCarousel({
            nav: true,
            items: 3,
            loop: false,
            navText: false,
            autoHeight: true,
            margin: 25,
            responsive: {0: {items: 1,}, 480: {items: 1,}, 768: {items: 2,}, 1200: {items: 2,}}
        });
        a(".clients.owl-carousel").imagesLoaded().owlCarousel({
            nav: true,
            items: 2,
            loop: false,
            navText: false,
            margin: 10,
            autoHeight: true,
            responsive: {0: {items: 2,}, 768: {items: 4,}, 1200: {items: 5,}}
        });
        a(".form-control").val("").on("focusin", function () {
            a(this).parent(".form-group").addClass("form-group-focus")
        }).on("focusout", function () {
            if (a(this).val().length === 0) {
                a(this).parent(".form-group").removeClass("form-group-focus")
            }
        });
    })
})(jQuery);