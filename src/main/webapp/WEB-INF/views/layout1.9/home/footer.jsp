<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="../../layout/taglib.jsp"%>
<div class="footer-v8">
		<footer class="footer">
			<div class="container">
				<div class="row">
					<div class="col-md-3 col-sm-6 column-one md-margin-bottom-50">
						<a href="index.html"><img class="footer-logo" src="<c:url value='/resources_1_9_5/img/logo1-default.png'/>" alt=""></a>
						<p class="margin-bottom-20">Elevysi.com</p>
						<span>Headquarters:</span>
						<p>Rodange, Luxembourg</p>
						<hr>
						<span>Phone:</span>
						
						<p>(+352) </p>
						<hr>
						<span>Email Address:</span>
						<a href="#">info@elevysi.com</a>
					</div>

					<div class="col-md-3 col-sm-6 md-margin-bottom-50">
						<h2>Tags</h2>
						<!-- Tag Links v4 -->
						<ul class="tags-v4 margin-bottom-40">
							<li><a class="rounded-4x" href="#">java</a></li>
							<li><a class="rounded-4x" href="#">spring</a></li>
							<li><a class="rounded-4x" href="#">social</a></li>
							<li><a class="rounded-4x" href="#">web</a></li>
							<li><a class="rounded-4x" href="#">technology</a></li>
							<li><a class="rounded-4x" href="#">social</a></li>
						</ul>
						<!-- End Tag Links v4 -->

						
						<!-- End Footer Lists -->
					</div>

					<div class="col-md-3 col-sm-6 md-margin-bottom-50">
						
					</div>

					<div class="col-md-3 col-sm-6">
						<h2>Newsletter</h2>
						<p><strong>Subscribe</strong> to our newsletter and stay up to date with the latest news and deals!</p><br>

						<!-- Form Group -->
						<div class="input-group margin-bottom-50">
							<input class="form-control" type="email" placeholder="Enter email">
							<div class="input-group-btn">
								<button type="button" class="btn-u input-btn">Subscribe</button>
							</div>
						</div>
						<!-- End Form Group -->

						<h2>Social Network</h2>
						<p><strong>Follow Us</strong> If you want to be kept up to date about what’s going on, minute by minute, then search for Grant and give us a follow!</p><br>

						<!-- Social Icons -->
						<ul class="social-icon-list margin-bottom-20">
							<li><a href="#"><i class="rounded-x fa fa-twitter"></i></a></li>
							<li><a href="#"><i class="rounded-x fa fa-facebook"></i></a></li>
							<li><a href="#"><i class="rounded-x fa fa-linkedin"></i></a></li>
							<li><a href="#"><i class="rounded-x fa fa-google-plus"></i></a></li>
							<li><a href="#"><i class="rounded-x fa fa-dribbble"></i></a></li>
						</ul>
						<!-- End Social Icons -->
					</div>
				</div><!--/end row-->
			</div><!--/end container-->
		</footer>

		<footer class="copyright">
			<div class="container">
				<ul class="list-inline terms-menu">
					<li>2016 &copy; All Rights Reserved.</li>
					<li class="home"><a href="#">Terms of Use</a></li>
					<li><a href="#">Privacy and Policy</a></li>
				</ul>
			</div><!--/end container-->
		</footer>
	</div>
	
	
	<!-- JS Implementing Plugins -->
<script src="<c:url value='/thematic_1_9/Blog/assets/plugins/back-to-top.js'/>"></script>
<script src="<c:url value='/thematic_1_9/Blog/assets/plugins/smoothScroll.js'/>"></script>
<%-- <script src="<c:url value='/thematic_1_9/Blog/assets/plugins/counter/waypoints.min.js'/>"></script> --%>
<%-- <script src="<c:url value='/thematic_1_9/Blog/assets/plugins/counter/jquery.counterup.min.js'/>"></script> --%>
<script src="<c:url value='/thematic_1_9/Blog/assets/plugins/owl-carousel/owl-carousel/owl.carousel.js'/>"></script>
<script src="<c:url value='/thematic_1_9/Blog/assets/plugins/master-slider/masterslider/masterslider.js'/>"></script>
<%-- <script src="<c:url value='/thematic_1_9/Blog/assets/plugins/master-slider/masterslider/jquery.easing.min.js'/>"></script> --%>
<script src="<c:url value='/thematic_1_9/Blog/assets/plugins/modernizr.js'/>"></script>
<script src="<c:url value='/thematic_1_9/Blog/assets/plugins/login-signup-modal-window/js/main.js'/>"></script> <!-- Gem jQuery -->
<!-- JS Customization -->
<script src="<c:url value='/thematic_1_9/Blog/assets/js/custom.js'/>"></script>
<!-- JS Page Level -->
<script src="<c:url value='/thematic_1_9/Blog/assets/js/app.js'/>"></script>
<script src="<c:url value='/thematic_1_9/Blog/assets/js/plugins/owl-carousel.js'/>"></script>
<script src="<c:url value='/thematic_1_9/Blog/assets/js/plugins/master-slider-showcase1.js'/>"></script>

<script type="text/javascript" src="<c:url value='/thematic_1_9/Blog/assets/plugins/scrollbar/js/jquery.mCustomScrollbar.concat.min.js'/>"></script>

<script>
	jQuery(document).ready(function() {
		App.init();
// 		App.initCounter();
		App.initScrollBar();
		FancyBox.initFancybox();
		OwlCarousel.initOwlCarousel();
		OwlCarousel.initOwlCarousel2();
		MasterSliderShowcase1.initMasterSliderShowcase1();
	});
</script>
<!--[if lt IE 9]>
	<script src="<c:url value='/thematic_1_9/Blog/assets/plugins/respond.js'/>"></script>
	<script src="<c:url value='/thematic_1_9/Blog/assets/plugins/html5shiv.js'/>"></script>
	<script src="<c:url value='/thematic_1_9/Blog/assets/plugins/placeholder-IE-fixes.js'/>"></script>
<![endif]-->

<tiles:insertAttribute name="bodyjs" />