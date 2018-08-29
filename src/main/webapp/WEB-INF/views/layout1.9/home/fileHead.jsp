<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../../layout/taglib.jsp"%>


	<!-- Meta -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Blog, Web, Development, Technology, Music, LifeStyle, Motivation, ">
	<meta name="author" content="Elvis Hatungimana">
	
	<meta name="_csrf" content="${_csrf.token}"/>
	<!-- default header name is X-CSRF-TOKEN -->
	<meta name="_csrf_header" content="${_csrf.headerName}"/>

	<!-- Favicon -->
	<link rel="shortcut icon" href="img/favicon.ico">

	<!-- Web Fonts -->
	<link rel='stylesheet' type='text/css' href='http://fonts.googleapis.com/css?family=Roboto+Slab:400,300,700'>

	<!-- CSS Global Compulsory -->
	<link rel="stylesheet" href="<c:url value='/thematic_1_9/Blog/assets/plugins/bootstrap/css/bootstrap.min.css'/>">
	<link rel="stylesheet" href="<c:url value='/thematic_1_9/Blog/assets/css/blog.style.css'/>">

	<!-- CSS Header and Footer -->
	<link rel="stylesheet" href="<c:url value='/thematic_1_9/Blog/assets/css/headers/header-v8.css'/> ">
	<link rel="stylesheet" href="<c:url value='/thematic_1_9/Blog/assets/css/footers/footer-v8.css'/>">

	<!-- CSS Implementing Plugins -->
	<link rel="stylesheet" href="<c:url value='/thematic_1_9/Blog/assets/plugins/animate.css'/>">
	<link rel="stylesheet" href="<c:url value='/thematic_1_9/Blog/assets/plugins/line-icons/line-icons.css'/>">
	<link rel="stylesheet" href="<c:url value='/thematic_1_9/Blog/assets/plugins/fancybox/source/jquery.fancybox.css'/>">
	<link rel="stylesheet" href="<c:url value='/thematic_1_9/Blog/assets/plugins/font-awesome/css/font-awesome.min.css'/>">
	<link rel="stylesheet" href="<c:url value='/thematic_1_9/Blog/assets/plugins/login-signup-modal-window/css/style.css'/>">
	<link rel="stylesheet" href="<c:url value='/thematic_1_9/Blog/assets/plugins/owl-carousel/owl-carousel/owl.carousel.css'/>">
	<link rel="stylesheet" href="<c:url value='/thematic_1_9/Blog/assets/plugins/master-slider/masterslider/style/masterslider.css'/>">
	<link rel="stylesheet" href="<c:url value='/thematic_1_9/Blog/assets/plugins/master-slider/masterslider/skins/default/style.css'/>">
	
	<link rel="stylesheet" href="<c:url value='/thematic_1_9/Blog/assets/plugins/scrollbar/css/jquery.mCustomScrollbar.css'/>">
	
	<!-- CSS Theme -->
	<link rel="stylesheet" href="<c:url value='/thematic_1_9/Blog/assets/css/theme-colors/default.css" id="style_color'/>">
	<link rel="stylesheet" href="<c:url value='/thematic_1_9/Blog/assets/css/theme-skins/dark.css'/>">

	<!-- CSS Customization -->
	<link rel="stylesheet" href="<c:url value='/thematic_1_9/Blog/assets/css/custom.css'/>">
	<link rel="stylesheet" href="<c:url value='/resources_1_9_5/css/app.css'/>">
	<link rel="stylesheet" href="<c:url value='/resources_1_9_5/css/blocks.css'/>">
	
	<!-- Own Css -->
	<link rel="stylesheet" href="<c:url value='/css/default.css'/>">
	
	<!-- JS Global Compulsory -->
	<script src="<c:url value='/thematic_1_9/Blog/assets/plugins/jquery/jquery.min.js'/>"></script>
	<script src="<c:url value='/thematic_1_9/Blog/assets/plugins/jquery/jquery-migrate.min.js'/>"></script>
	<script src="<c:url value='/thematic_1_9/Blog/assets/plugins/bootstrap/js/bootstrap.min.js'/>"></script>
	
	<!-- FancyBox -->
	<script type="text/javascript" src="<c:url value='/resources_1_9_5/plugins/fancybox/source/jquery.fancybox.pack.js'/>"></script>
	