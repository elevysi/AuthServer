<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<head>
<%@ include file="../../../layout/taglib.jsp"%>
	<title>Elevysi | Error</title>

	<!-- Meta -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">

	<!-- Favicon -->
	<link rel="shortcut icon" href="favicon.ico">

	<!-- Web Fonts -->
	<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Open+Sans:400,300,700&amp;subset=cyrillic,latin">

	<!-- CSS Global Compulsory -->
	<link rel="stylesheet" href="<c:url value='/resources_1_9_5/plugins/bootstrap/css/bootstrap.min.css' />">
	<link rel="stylesheet" href="<c:url value='/resources_1_9_5/css/style.css'/>">

	<!-- CSS Header and Footer -->
	<link rel="stylesheet" href="<c:url value='/resources_1_9_5/css/headers/header-default.css'/>">
	<link rel="stylesheet" href="<c:url value='/resources_1_9_5/css/footers/footer-v1.css'/>">

	<!-- CSS Implementing Plugins -->
	<link rel="stylesheet" href="<c:url value='/resources_1_9_5/plugins/animate.css'/>">
	<link rel="stylesheet" href="<c:url value='/resources_1_9_5/plugins/line-icons/line-icons.css'/>">
	<link rel="stylesheet" href="<c:url value='/resources_1_9_5/plugins/font-awesome/css/font-awesome.min.css'/>">

	<!-- CSS Page Style -->
	<link rel="stylesheet" href="<c:url value='/resources_1_9_5/css/pages/page_404_error4.css'/>">

	<!-- CSS Customization -->
	<link rel="stylesheet" href="<c:url value='/resources_1_9_5/css/custom.css'/>">
</head>

<body>
	
	<c:url var="errorImageUrl" value="/resources_1_9_5/img/error/error-v5.jpg"/>
	
	
	<!--=== Error V5 ===-->
	<div class="container valign__middle">
		<!--Error Block-->
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<div class="error-v5">
					<a class="logo-a" href="#"><img alt="" src="<c:url value='/resources_1_9_5/img/logo1-default.png'/>" class="logo"></a>
					<h1>There was an error!</h1>
					<span class="sorry">
					
					<c:if test="${not empty exception.message}">
						<c:out value="${exception.message}" />
					</c:if>
					
					
					</span>
					<img class="error-img" src="<c:url value='/resources_1_9_5/img/error/error-404-v5.png'/>" alt="error">
					<form action="<spring:url value="/public/search"/>" method="post">
						<div class="input-group col-md-12">
							<input type="text" class="form-control" placeholder="Try to find something" name="globalSearch">
							<span class="input-group-btn">
								<button class="btn-u" type="submit">Search</button>
							</span>
						</div><!-- /input-group -->
					</form>
					<br>
					<span><a href="<c:url value='/'/>">Back home</a></span>
				</div>
			</div>
		</div>
	</div><!--/container-->
	<!--End Error Block-->

	<!--=== Sticky Footer ===-->
	<div class="container sticky-footer">
		<p class="copyright-space">
			2016 &copy; All Rights Reserved.<a href="http://elevysi.com/" target="_blank" class="color-green"> Elevysi</a>
		</p>
	</div>
	<!--=== End Sticky Footer ===-->

	<!-- JS Global Compulsory -->
	<script src="<c:url value='/resources_1_9_5/plugins/jquery/jquery.min.js'/>"></script>
	<script src="<c:url value='/resources_1_9_5/plugins/jquery/jquery-migrate.min.js'/>"></script>
	<script src="<c:url value='/resources_1_9_5/plugins/bootstrap/js/bootstrap.min.js'/>"></script>

	<!-- JS Implementing Plugins -->
	<script src="<c:url value='/resources_1_9_5/plugins/back-to-top.js'/>"></script>
	<script src="<c:url value='/resources_1_9_5/plugins/backstretch/jquery.backstretch.min.js'/>"></script>

	<!-- JS Page Level -->
	<script src="<c:url value='/resources_1_9_5/js/app.js'/>"></script>

	<script>
		jQuery(document).ready(function() {
			App.init();
		});
		$.backstretch([
			"${errorImageUrl}"
			])
	</script>
	<!--[if lt IE 9]>
	<script src="<c:url value='/resources_1_9_5/plugins/respond.js'/>"></script>
	<script src="<c:url value='/resources_1_9_5/plugins/html5shiv.js'/>"></script>
	<script src="<c:url value='/resources_1_9_5/plugins/placeholder-IE-fixes.js'/>"></script>
	<![endif]-->
</body>
</html>
