
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<head>
<%@ include file="../../../layout/taglib.jsp"%>
	<title>Coming Soon | NODEJS | ASP.NET MVC</title>

	<!-- Meta -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">

	<!-- Favicon -->
	<link rel="shortcut icon" href="favicon.ico">

	<!-- Web Fonts -->
	<link rel='stylesheet' type='text/css' href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600&amp;subset=cyrillic,latin'>

	<!-- CSS Global Compulsory-->
	<link rel="stylesheet" href="<c:url value='/resources_1_9_5/plugins/bootstrap/css/bootstrap.min.css' />">
	<link rel="stylesheet" href="<c:url value='/resources_1_9_5/css/style.css'/>">

	<!-- CSS Implementing Plugins -->
	<link rel="stylesheet" href="<c:url value='/resources_1_9_5/plugins/animate.css'/>">
	<link rel="stylesheet" href="<c:url value='/resources_1_9_5/plugins/line-icons/line-icons.css'/>">
	<link rel="stylesheet" href="<c:url value='/resources_1_9_5/plugins/font-awesome/css/font-awesome.css'/>">

	<!-- CSS Page Style -->
	<link rel="stylesheet" href="<c:url value='/resources_1_9_5/css/pages/page_coming_soon.css'/>">

	<!-- CSS Theme -->
	<link rel="stylesheet" href="<c:url value='/resources_1_9_5/css/theme-colors/default.css" id="style_color'/>">
</head>

<body class="coming-soon-page">
	<div class="coming-soon-border"></div>
	<div class="coming-soon-bg-cover"></div>

	<!--=== Content Part ===-->
	<div class="container cooming-soon-content valign__middle">
		<!-- Coming Soon Content -->
		<div class="row">
			<div class="col-md-12 coming-soon">
				<h1>Coming Soon</h1>
				<p>Node JS and ASP.NET MVC Demo to be soon included.</p><br>
				<form>
					<div class="input-group col-md-4 col-md-offset-4">
						<input type="text" class="form-control" placeholder="Your Email">
						<span class="input-group-btn">
							<button class="btn-u" type="button">Subscribe</button>
						</span>
					</div><!-- /input-group -->
				</form>
			</div>
		</div>

		<!-- Coming Soon Plugn -->
		<div class="coming-soon-plugin" style="height: 200px;">
			<div id="defaultCountdown"></div>
		</div>
	</div><!--/container-->
	<!--=== End Content Part ===-->

	<!--=== Sticky Footer ===-->
	<div class="sticky-footer">
		<p class="copyright-space">
			2016 &copy; <a href="<c:url value='/' />">Elevysi</a>. ALL Rights Reserved.
		</p>
	</div>
	<!--=== End Sticky-Footer ===-->

	<!-- JS Global Compulsory -->
	<script type="text/javascript" src="<c:url value='/resources_1_9_5/plugins/jquery/jquery.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources_1_9_5/plugins/jquery/jquery-migrate.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources_1_9_5/plugins/bootstrap/js/bootstrap.min.js'/>"></script>
	<!-- JS Implementing Plugins -->
	<script type="text/javascript" src="<c:url value='/resources_1_9_5/plugins/back-to-top.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources_1_9_5/plugins/smoothScroll.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources_1_9_5/plugins/countdown/jquery.plugin.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources_1_9_5/plugins/countdown/jquery.countdown.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources_1_9_5/plugins/backstretch/jquery.backstretch.min.js'/>"></script>
	<!-- JS Customization -->
	<script type="text/javascript" src="<c:url value='/resources_1_9_5/js/custom.js'/>"></script>
	<!-- JS Page Level -->
	<script type="text/javascript" src="<c:url value='/resources_1_9_5/js/app.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources_1_9_5/js/pages/page_coming_soon.js'/>"></script>
	<script type="text/javascript">
		jQuery(document).ready(function() {
			App.init();
			PageComingSoon.initPageComingSoon();
		});
	</script>
	<c:url var="firstImage" value="/resources_1_9_5/img/bg/14.jpg" />
	<c:url var="secondImage" value="/resources_1_9_5/img/bg/17.jpg" />
	<c:url var="thirdImage" value="/resources_1_9_5/img/bg/2.jpg" />

	<!-- Background Slider (Backstretch) -->
	<script>
		$.backstretch([
			"${firstImage}",
			"${secondImage}",
			"${thirdImage}"
			], {
				fade: 1000,
				duration: 7000
			});
	</script>
	<!--[if lt IE 9]>
	<script src="<c:url value='/resources_1_9_5/plugins/respond.js'/>"></script>
	<script src="<c:url value='/resources_1_9_5/plugins/html5shiv.js'/>"></script>
	<script src="<c:url value='/resources_1_9_5/plugins/placeholder-IE-fixes.js'/>"></script>
	<![endif]-->
</body>
</html>
s