<%@ include file="../../layout/taglib.jsp"%>

<!--=== Top Bar ===-->
<div class="blog-topbar">
			<div class="topbar-search-block">
				<div class="container">
					<form action="<spring:url value="/public/search"/>" method="post">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<input type="text" class="form-control" placeholder="Search" name="globalSearch">
						<div class="search-close"><i class="icon-close"></i></div>
					</form>
					
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-sm-8 col-xs-8">
						<div class="topbar-time"><c:out value="${currentDate}"/></div>
						<div class="topbar-toggler"><span class="fa fa-angle-down"></span></div>
						<ul class="topbar-list topbar-menu">
							<li><a href="http://elevysi.com">Elevysi.com</a></li>
							
							
							<security:authorize access="isAuthenticated()">
								<li class="cd-log_reg hidden-sm hidden-md hidden-lg"><strong><a class="cd-signin" href='<spring:url value="/logout"></spring:url>'>Logout</a></strong></li>
							</security:authorize>
							
							<security:authorize access="!isAuthenticated()">
								<li class="cd-log_reg hidden-sm hidden-md hidden-lg"><strong><a class="cd-signin" href="javascript:void(0);">Login</a></strong></li>
								
							</security:authorize>
							
							<li class="cd-log_reg hidden-sm hidden-md hidden-lg"><strong><a class="cd-signup" href="javascript:void(0);">Register</a></strong></li>
							
							
							
						</ul>
					</div>
					<div class="col-sm-4 col-xs-4 clearfix">
						<i class="fa fa-search search-btn pull-right"></i>
						<ul class="topbar-list topbar-log_reg pull-right visible-sm-block visible-md-block visible-lg-block">
							<li class="cd-log_reg home"><a class="cd-signin" href="javascript:void(0);">Login</a></li>
							<li class="cd-log_reg"><a class="cd-signup" href="javascript:void(0);">Register</a></li>
						</ul>
					</div>
				</div><!--/end row-->
			</div><!--/end container-->
		</div>
<!--=== End Bar ===-->