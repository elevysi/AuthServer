<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="../../layout/taglib.jsp"%>
<div class="navbar mega-menu" role="navigation">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="res-container">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>

					<div class="navbar-brand">
						<a href="<spring:url value="/"/>">
							<img src="<c:url value='/resources_1_9_5/img/logo1-default.png'/>" alt="Logo">
						</a>
					</div>
				</div><!--/end responsive container-->

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse navbar-responsive-collapse">
					<div class="res-container">
						<ul class="nav navbar-nav">
							<!-- Home -->
                    		<li class=" home active "><a href="<spring:url value="/"/>"> Home </a></li>
							<li class="dropdown">
								<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
									Blogs
								</a>
								<ul class="dropdown-menu">
									<li class="active"><a href="<spring:url value="/"/>">Spring</a></li>
									<li><a href="<spring:url value="http://elevysi.com/posts/timeline"/>">Cake PHP</a></li>
								</ul>
							</li>
							<!-- End Home -->
							
							<!-- Confettis -->
							<li class="dropdown">
								
								<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">Confettis</a>
								<ul class="dropdown-menu">
									<li><a href="<spring:url value="/public/posts"/>">Posts</a></li>
									<li><a href="<spring:url value="/public/plays"/>">Plays</a></li>
									<li><a href="<spring:url value="/public/albums"/>">Albums</a></li>
									<li><a href="<spring:url value="/public/dossiers"/>">Dossiers</a></li>
									<li><a href="<spring:url value="/public/profiles"/>">Profiles</a></li>
									
								</ul>
							</li>
							
							
							<li class="dropdown">
						
								<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">Create</a>
								<ul class="dropdown-menu">
									<li><a href="<spring:url value="/posts/add"/>">Add Post</a></li>
									<li><a href="<spring:url value="/plays/add"/>">Add Play</a></li>
									<li><a href="<spring:url value="/albums/add"/>">Add Album</a></li>
									<li><a href="<spring:url value="/dossiers/add"/>">Add Dossier</a></li>
									
								</ul>
							</li>
							
							<!-- End Shopping -->
							
							<!-- Shopping -->
							<li><a href="<spring:url value="/shop/"/>">Shop</a></li>
							<!-- End Shopping -->

							
							 <security:authorize access="isAuthenticated()">

								<!-- Profile -->
								<li class="dropdown">
								
									<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">Profile</a>
										<ul class="dropdown-menu">
											<li><a href="<spring:url value="/profile/"/>">Home - <security:authentication property="principal.username" /></a></li>
											<li><a href="<spring:url value="/updatePassword"/>">Password Update</a></li>
										</ul>
								
								</li>
								<!-- End Profile -->
								
								
								
								<!-- Admin -->
								<security:authorize access="hasRole('ROLE_ADMIN')">
									<li class="dropdown">
									
										<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">Admin</a>
											<ul class="dropdown-menu">
												<li><a href="<spring:url value="/admin/dashboard"/>">Dashboard</a></li>
												<li><a href="<spring:url value="/admin/users"/>">Users</a></li>
												<li><a href="<spring:url value="/admin/profiles"/>">Profiles</a></li>
											</ul>
									</li>
									
								
								</security:authorize>
								<!-- End Admin -->
							
							
							
							<!-- Sign -->
								<li><a class="logoutBtn" href="<spring:url value="/logout"/>">Sign out</a></li>
							<!-- End Sign -->
							
							</security:authorize>
							
							<security:authorize access="!isAuthenticated()">
								<li><a href="<spring:url value="/auth/rqstd/login"/>">Sign in</a></li>
							</security:authorize>
							
						</ul>
					</div><!--/responsive container-->
				</div><!--/navbar-collapse-->
			</div><!--/end contaoner-->
		</div>