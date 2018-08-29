<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="../../layout/taglib.jsp"%>
<!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse mega-menu navbar-responsive-collapse">
            <div class="container">
                <ul class="nav navbar-nav">
                    <!-- Home -->
                    <li><a href="<spring:url value="/"/>">Home</a></li>
                    <li class="dropdown">
								<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">Blogs</a>
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
					
					<!-- End Confettis -->
					
					<!-- Shopping -->
						<li><a href="<spring:url value="/shop/"/>">Shop</a></li>
					<!-- End Shopping -->
                    
                    <security:authorize access="isAuthenticated()">
						<!-- Blog -->
						<li class="dropdown"><a href="javascript:void(0);"
							class="dropdown-toggle" data-toggle="dropdown"> Profile</a>
							<ul class="dropdown-menu">
								<li><a href="<spring:url value="/profile/"/>">Home - <security:authentication property="principal.username" /></a></li>
								<li><a href="<spring:url value="/updatePassword"/>">Password Update</a></li>
							</ul>
						</li>
						<!-- End Blog -->
					
					
	
						<security:authorize access="hasRole('ROLE_ADMIN')">
							
							<!-- Admin -->
							<li class="dropdown"><a href="javascript:void(0);"
								class="dropdown-toggle" data-toggle="dropdown"> Admin</a>
								<ul class="dropdown-menu">
									<li><a href="<spring:url value="/admin/dashboard"/>">Dashboard</a></li>
									<li><a href="<spring:url value="/admin/featured"/>">Featured</a></li>
									<li><a href="<spring:url value="/admin/users"/>">Users</a></li>
									<li><a href="<spring:url value="/admin/profiles"/>">Profiles</a></li>
								</ul>
							</li>
							<!-- End Admin -->
						</security:authorize>
						<c:url var="logoutPostUrl" value="/logout" />
						<li><a class="logoutBtn" href="<spring:url value="/logout"/>">Sign out</a></li>
						
						
						
					</security:authorize>
					
					<security:authorize access="!isAuthenticated()">
						<li><a href="<spring:url value="/auth/rqstd/login"/>">Sign in</a></li>
					</security:authorize>

                    

                    <!-- Search Block -->
                    <li>
                        <i class="search fa fa-search search-btn"></i>
                        <div class="search-open">
                        	<form action="<spring:url value="/public/search"/>" method="post">
                        	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            	<div class="input-group animated fadeInDown">
									<input type="text" class="form-control" placeholder="Search" name="globalSearch">
	                                <span class="input-group-btn">
	                                    <input class="btn-u" type="submit" value="Go">
	                                </span>
                              
                            	</div>
                            </form>
                        </div>
                    </li>
                    <!-- End Search Block -->
                </ul>
            </div><!--/end container-->
        </div><!--/navbar-collapse-->