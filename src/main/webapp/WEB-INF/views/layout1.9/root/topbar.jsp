<%@ include file="../../layout/taglib.jsp"%>
<div class="container">
	<!-- Logo -->
	<a href="<c:url value='/'/>" class="logo">
    	<img src="<c:url value='/resources_1_9_5/img/logo1-default.png'/>" alt="Logo">
	</a>
	<!-- End Logo -->

	<!-- Topbar -->
	<div class="topbar">
		<ul class="loginbar pull-right">
			<li class="hoverSelector"><i class="fa fa-globe"></i> <a>Languages</a>
				<ul class="languages hoverSelectorBlock">
					<li class="active"><a href="?locale=en">English <i class="fa fa-check"></i></a></li>
					<li><a href="?locale=fr">French</a></li>
				</ul></li>
			<li class="topbar-devider"></li>
			<li><a href="#">Help</a></li>
			<li class="topbar-devider"></li>
			<li><a href="http://elevysi.com">Elevysi.com</a></li>
		</ul>
	</div>
	<!-- End Topbar -->

	<!-- Toggle get grouped for better mobile display -->
	<button type="button" class="navbar-toggle" data-toggle="collapse"
		data-target=".navbar-responsive-collapse">
		<span class="sr-only">Toggle navigation</span> <span
			class="fa fa-bars"></span>
	</button>
	<!-- End Toggle -->
</div>
<!--/end container-->