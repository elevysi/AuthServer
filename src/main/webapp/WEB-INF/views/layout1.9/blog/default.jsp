
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<head>
	<%@ include file="../../layout/taglib.jsp"%>
    <tiles:insertAttribute name="headTag" />

<c:choose>
	<c:when test="${not empty  pageTitle}">
		<title><c:out value="${pageTitle} - Elevysi"/></title>
	</c:when>
	<c:otherwise>
		<title><tiles:getAsString name="title" ignore="true"/></title>
	</c:otherwise>
</c:choose>
    	
</head>



<body>
	<div class="wrapper">
		<!--=== Header ===-->
		<div class="header">
			<tiles:insertAttribute name="topbar" />
			<tiles:insertAttribute name="navbar" />
		</div>
		<!--=== End Header ===-->
		

		<!--=== Breadcrumbs ===-->
		<div class="breadcrumbs">
			<tiles:insertAttribute name="breadcrumb" />
		</div><!--/breadcrumbs-->
		<!--=== End Breadcrumbs ===-->

		<!--=== Blog Posts ===-->
	   
	        <div class="container content-sm">
	            <div class="row">
	                <!-- Blog All Posts -->
	                
		                <c:if test="${sessionMessage.msgText != null}">
							<div class="${sessionMessage.msgClass}">
								<button class="close" aria-hidden="true" data-dismiss="alert" type="button">x</button>
								<c:out value="${sessionMessage.msgText}"></c:out>
							</div>
						</c:if>
						<tiles:insertAttribute name="body" />
	                
	                
	                
	            </div>
	        </div><!--/end container-->
	    
	    <!--=== End Blog Posts ===-->

		<!--=== Footer Version 1 ===-->
		<div class="footer-v1">
		
		<tiles:insertAttribute name="footer" />
		</div>
		<!--=== End Footer Version 1 ===-->
	</div>

</body>
</html>
