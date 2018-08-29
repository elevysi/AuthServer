<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->  
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->  
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->  
<head>
    <%@ include file="taglib.jsp" %>
    <title><tiles:getAsString name="title"/></title>

    <!-- Meta -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Favicon -->
    <link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>">

    <!-- CSS Global Compulsory -->
    <link rel="stylesheet" href="<c:url value='/resources/plugins/bootstrap/css/bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">

    <!-- CSS Implementing Plugins -->
    <link rel="stylesheet" href="<c:url value='/resources/plugins/line-icons/line-icons.css'/>">
    <link rel="stylesheet" href="<c:url value='/resources/plugins/font-awesome/css/font-awesome.min.css'/>">

    <!-- CSS Page Style -->    
    <link rel="stylesheet" href="<c:url value='/resources/css/pages/page_log_reg_v2.css'/>">    

    <!-- CSS Theme -->    
    <link rel="stylesheet" href="<c:url value='/resources/css/themes/default.css" id="style_color'/>">

    <!-- CSS Customization -->
    <link rel="stylesheet" href="<c:url value='/resources/css/custom.css'/>">
</head> 

<body>
  

<!--=== Content Part ===-->    
<div class="container">
  	<tiles:insertAttribute name="body"/>  
</div><!--/container-->
<!--=== End Content Part ===-->

<!-- JS Global Compulsory -->           
<script type="text/javascript" src="<c:url value='/resources/plugins/jquery-1.10.2.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/plugins/jquery-migrate-1.2.1.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/plugins/bootstrap/js/bootstrap.min.js'/>"></script> 
<!-- JS Implementing Plugins -->           
<%-- <script type="text/javascript" src="<c:url value='/resources/plugins/back-to-top.js'/>"></script> --%>
<script type="text/javascript" src="<c:url value='/resources/plugins/countdown/jquery.countdown.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/plugins/backstretch/jquery.backstretch.min.js'/>"></script>
<script type="text/javascript">
    $.backstretch([
      "<c:url value='/resources/img/bg/5.jpg' />",
      "<c:url value='/resources/img/bg/4.jpg' />",
      ], {
        fade: 1000,
        duration: 7000
    });
</script>
<!-- JS Page Level -->           
<script type="text/javascript" src="<c:url value='/resources/js/app.js'/>"></script>
<script type="text/javascript">
    jQuery(document).ready(function() {
        App.init();
    });
</script>
<!--[if lt IE 9]>
    <script src="<c:url value='/resources/plugins/respond.js'/>"></script>
    <script src="<c:url value='/resources/plugins/html5shiv.js'/>"></script>
<![endif]-->

<script type="text/javascript">
  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-29166220-1']);
  _gaq.push(['_setDomainName', 'htmlstream.com']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();
</script>

<!-- Jquery Validator -->
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>	

</body>
</html> 