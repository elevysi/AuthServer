
<!-- Meta -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../../layout/taglib.jsp"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<c:choose>
	<c:when test="${not empty  pageDescription}">
		<meta name="description" content="<c:out value='${pageDescription}' />" />
		
	</c:when>
	<c:otherwise>
		<meta name="description" content="Blog, Web, Development, Technology, Music, LifeStyle, Motivation">
	</c:otherwise>
</c:choose>

<meta name="author" content="Elevysi">

<meta name="_csrf" content="<c:out value='${_csrf.token}' />"/>
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="<c:out value='${_csrf.headerName}' />"/>

<!-- Favicon -->
<link rel="shortcut icon" href="<c:url value='/img/favicon.ico' />">

<!-- Web Fonts -->
<link rel='stylesheet' type='text/css' href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600&amp;subset=cyrillic,latin'>

<!-- Jquery UI -->
<link rel="stylesheet" href="<c:url value='/js/jquery/jquery-ui-1.10.4.custom/css/smoothness/jquery-ui.min.css'/>">

<!-- CSS Global Compulsory -->
<link rel="stylesheet" href="<c:url value='/resources_1_9_5/plugins/bootstrap/css/bootstrap.min.css'/>">
<link rel="stylesheet" href="<c:url value='/resources_1_9_5/css/style.css'/>">

<!-- CSS Header and Footer -->
<link rel="stylesheet" href="<c:url value='/resources_1_9_5/css/headers/header-default.css'/>">
<link rel="stylesheet" href="<c:url value='/resources_1_9_5/css/footers/footer-v1.css'/>">

<!-- CSS Implementing Plugins -->
<link rel="stylesheet" href="<c:url value='/resources_1_9_5/plugins/animate.css'/>">
<link rel="stylesheet" href="<c:url value='/resources_1_9_5/plugins/line-icons/line-icons.css'/>">
<link rel="stylesheet" href="<c:url value='/resources_1_9_5/plugins/font-awesome/css/font-awesome.min.css'/>">
<link rel="stylesheet" href="<c:url value='/resources_1_9_5/plugins/fancybox/source/jquery.fancybox.css'/>">
<link rel="stylesheet" href="<c:url value='/resources_1_9_5/plugins/scrollbar/css/jquery.mCustomScrollbar.css'/>">
<link rel="stylesheet" href="<c:url value='/resources_1_9_5/plugins/sky-forms-pro/skyforms/css/sky-forms.css'/>">
<link rel="stylesheet" href="<c:url value='/resources_1_9_5/plugins/sky-forms-pro/skyforms/custom/custom-sky-forms.css'/>">
<!-- CSS Theme -->
<link rel="stylesheet" href="<c:url value='/resources_1_9_5/css/theme-colors/default.css" id="style_color'/>">


<!-- Own Css -->
<link rel="stylesheet" href="<c:url value='/css/default.css'/>">

<!-- JS Global Compulsory -->
<script type="text/javascript" src="<c:url value='/resources_1_9_5/plugins/jquery/jquery.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources_1_9_5/plugins/jquery/jquery-migrate.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources_1_9_5/plugins/bootstrap/js/bootstrap.min.js'/>"></script>

<!-- Jquery Validator -->
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>
<script type="text/javascript" src="<c:url value='/js/jquery/jquery-ui-1.10.4.custom/js/jquery-ui-1.10.4.custom.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery.ui.autocomplete.html.js'/>"></script>

<%-- <script type="text/javascript" src="<c:url value='/js/jQuery-Autocomplete-master/src/jquery.autocomplete.js'/>"></script>
 --%>
<!-- FancyBox -->
<script type="text/javascript" src="<c:url value='/resources_1_9_5/plugins/fancybox/source/jquery.fancybox.pack.js'/>"></script>

<!--React-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/react/15.2.1/react.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/react/15.2.1/react-dom.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.34/browser.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/remarkable/1.6.2/remarkable.min.js"></script>

