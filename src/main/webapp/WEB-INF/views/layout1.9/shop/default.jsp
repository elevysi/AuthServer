<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<head>
	<%@ include file="../../layout/taglib.jsp"%>
	   <tiles:insertAttribute name="headTag" />
	   <title><tiles:getAsString name="title" /></title>
</head>

<body class="header-fixed">


<div class="wrapper">
	<!--=== Header v5 ===-->
	<div class="header-v5 header-static">
		<!-- Topbar v3 -->
		<tiles:insertAttribute name="topbar" />
		<!-- End Topbar v3 -->

		<!-- Navbar -->
		<tiles:insertAttribute name="navbar" />
		<!-- End Navbar -->
	</div>
	<!--=== End Header v5 ===-->

	<!--=== Slider ===-->
	<tiles:insertAttribute name="slider" />
	<!--=== End Slider ===-->

	<tiles:insertAttribute name="body"/>
	
	<tiles:insertAttribute name="sponsor"/>
	<tiles:insertAttribute name="subscribe"/>

	<!--=== Footer v4 ===-->
	<tiles:insertAttribute name="footer" />
	<!--=== End Footer v4 ===-->
</div><!--/wrapper-->

<!-- Wait Block -->
<div class="g-popup-wrapper">
	<div class="g-popup g-popup--discount2">
		<div class="g-popup--discount2-message">
		  <h3>Want 10% Off?</h3>
		  <h4>You Are Fabulous!</h4>
		  <p>Get 10% Off Your Next Purchase! Just Type Email Below!</p>

			<form action="#" class="sky-form">
				<label class="input">
					<input type="email" placeholder="Email" class="form-control">
				</label>
				<label class="input">
					<button class="btn btn-default" type="button">Subscribe</button>
				</label>
			</form>
		</div>
		<img src="<c:url value='/thematic_1_9/Shop/assets/img/blog/26.jpg'/>" alt="ALT" width="270">
	  <a href="javascript:void(0);" class="g-popup__close g-popup--discount2__close"><span class="icon-close" aria-hidden="true"></span></a>
	</div>
</div>
<!-- End Wait Block -->

<!-- JS Global Compulsory -->
<script src="<c:url value='/thematic_1_9/Shop/assets/plugins/jquery/jquery.min.js'/>"></script>
<script src="<c:url value='/thematic_1_9/Shop/assets/plugins/jquery/jquery-migrate.min.js'/>"></script>
<script src="<c:url value='/thematic_1_9/Shop/assets/plugins/bootstrap/js/bootstrap.min.js'/>"></script>
<!-- JS Implementing Plugins -->
<script src="<c:url value='/thematic_1_9/Shop/assets/plugins/back-to-top.js'/>"></script>
<script src="<c:url value='/thematic_1_9/Shop/assets/plugins/smoothScroll.js'/>"></script>
<script src="<c:url value='/thematic_1_9/Shop/assets/plugins/jquery.parallax.js'/>"></script>
<script src="<c:url value='/thematic_1_9/Shop/assets/plugins/owl-carousel/owl-carousel/owl.carousel.js'/>"></script>
<script src="<c:url value='/thematic_1_9/Shop/assets/plugins/scrollbar/js/jquery.mCustomScrollbar.concat.min.js'/>"></script>
<script src="<c:url value='/thematic_1_9/Shop/assets/plugins/revolution-slider/rs-plugin/js/jquery.themepunch.tools.min.js'/>"></script>
<script src="<c:url value='/thematic_1_9/Shop/assets/plugins/revolution-slider/rs-plugin/js/jquery.themepunch.revolution.min.js'/>"></script>

<!-- Master Slider -->
<script src="<c:url value='/thematic_1_9/Shop/assets/plugins/master-slider/quick-start/masterslider/masterslider.min.js'/>"></script>
<script src="<c:url value='/thematic_1_9/Shop/assets/plugins/master-slider/quick-start/masterslider/jquery.easing.min.js'/>"></script>


<!-- JS Customization -->
<script src="<c:url value='/thematic_1_9/Shop/assets/js/custom.js'/>"></script>
<!-- JS Page Level -->
<script src="<c:url value='/thematic_1_9/Shop/assets/js/shop.app.js'/>"></script>
<script src="<c:url value='/thematic_1_9/Shop/assets/js/plugins/owl-carousel.js'/>"></script>
<script src="<c:url value='/thematic_1_9/Shop/assets/js/plugins/revolution-slider.js'/>"></script>
<script src="<c:url value='/thematic_1_9/Shop/assets/js/plugins/style-switcher.js'/>"></script>
<script>
	jQuery(document).ready(function() {
		App.init();
		App.initScrollBar();
		App.initParallaxBg();
		OwlCarousel.initOwlCarousel();
		RevolutionSlider.initRSfullWidth();
		StyleSwitcher.initStyleSwitcher();
});
</script>
<!--[if lt IE 9]>
	<script src="<c:url value='/thematic_1_9/Shop/assets/plugins/respond.js'/>"></script>
	<script src="<c:url value='/thematic_1_9/Shop/assets/plugins/html5shiv.js'/>"></script>
	<script src="<c:url value='/thematic_1_9/Shop/assets/js/plugins/placeholder-IE-fixes.js'/>"></script>
<![endif]-->

</body>
</html>
