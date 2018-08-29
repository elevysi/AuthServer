<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<head>
	<%@ include file="../../layout/taglib.jsp"%>
   <tiles:insertAttribute name="headTag" />
   <c:choose>
		<c:when test="${not empty  pageTitle}">
			<title><c:out value="${pageTitle}"/></title>
		</c:when>
		<c:otherwise>
			<title><tiles:getAsString name="title" ignore="true"/></title>
		</c:otherwise>
	</c:choose>
</head>

<body class="header-fixed header-fixed-space-v2">

<div class="wrapper">
	<!--=== Header v8 ===-->
	<div class="header-v8 header-sticky">
		<!-- Topbar blog -->
		<tiles:insertAttribute name="topbar" />
		<!-- End Topbar blog -->

		<!-- Navbar -->
		<tiles:insertAttribute name="navbar" />
		<!-- End Navbar -->
	</div>
	<!--=== End Header v8 ===-->

	<!-- Master Slider -->
	<div class="blog-ms-v1 content-sm bg-color-darker margin-bottom-60">
		<tiles:insertAttribute name="sliderMaster" />
	</div>
	<!-- End Master Slider -->
	
	</div>
	
	<!--=== Container Part ===-->
	<div class="container margin-bottom-40">
		<div class="row">
			<!-- Main Content -->
			<div class="col-md-9">
			<c:if test="${sessionMessage.msgText != null}">
					<div class="${sessionMessage.msgClass}">
						<button class="close" aria-hidden="true" data-dismiss="alert" type="button">×</button>
						<c:out value="${sessionMessage.msgText}"></c:out>
					</div>
			</c:if>			
			<!-- End Main Content -->
				<tiles:insertAttribute name="body" />
			</div>
			<!-- Right Sidebar -->
			<div class="col-md-3">
				<tiles:insertAttribute name="rightVBar" />
			</div>
			<!-- End Right Sidebar -->
		</div>
	</div>
	
	<c:url var="modalLoginUrl" value="/login/modal" />
	<c:url var="modalRegisterUrl" value="/register/modal" />
	
	<!--=== End Container Part ===-->

	<!--=== Footer v8 ===-->
	<tiles:insertAttribute name="footer" /> 
	<!--=== End Footer v8 ===-->

	<div class="cd-user-modal"> <!-- this is the entire modal form, including the background -->
		<div class="cd-user-modal-container"> <!-- this is the container wrapper -->
			<ul class="cd-switcher">
				<li><a href="javascript:void(0);">Login</a></li>
				<li><a href="javascript:void(0);">Register</a></li>
			</ul>

			<div id="cd-login"> <!-- log in form -->
				<form class="cd-form" action="${modalLoginUrl}" method="post">
					<p class="social-login">
						<span class="social-login-facebook"><a href="#"><i class="fa fa-facebook"></i> Facebook</a></span>
						<span class="social-login-google"><a href="#"><i class="fa fa-google"></i> Google</a></span>
						<span class="social-login-twitter"><a href="#"><i class="fa fa-twitter"></i> Twitter</a></span>
					</p>

					<div class="lined-text"><span>Or use your account on Blog</span><hr></div>

					<p class="fieldset">
						<label class="image-replace cd-email" for="signin-email">Username</label>
						<input class="full-width has-padding has-border" id="signin-email" type="text" placeholder="Username">
						<span class="cd-error-message">Error message here!</span>
					</p>

					<p class="fieldset">
						<label class="image-replace cd-password" for="signin-password">Password</label>
						<input class="full-width has-padding has-border" id="signin-password" type="text"  placeholder="Password">
						<a href="javascript:void(0);" class="hide-password">Hide</a>
						<span class="cd-error-message">Error message here!</span>
					</p>

					<p class="fieldset">
						<input type="checkbox" id="remember-me" checked>
						<label for="remember-me">Remember me</label>
					</p>

					<p class="fieldset">
						<input class="full-width" type="submit" value="Login" id="loginModalBtn">
					</p>
				</form>

				<p class="cd-form-bottom-message"><a href="javascript:void(0);">Forgot your password?</a></p>
				<!-- <a href="javascript:void(0);" class="cd-close-form">Close</a> -->
			</div> <!-- cd-login -->

			<div id="cd-signup"> <!-- sign up form -->
				<form class="cd-form">
					<p class="social-login">
						<span class="social-login-facebook"><a href="#"><i class="fa fa-facebook"></i> Facebook</a></span>
						<span class="social-login-google"><a href="#"><i class="fa fa-google"></i> Google</a></span>
						<span class="social-login-twitter"><a href="#"><i class="fa fa-twitter"></i> Twitter</a></span>
					</p>

					<div class="lined-text"><span>Or register your new account on Blog</span><hr></div>

					<p class="fieldset">
						<label class="image-replace cd-username" for="signup-username">Username</label>
						<input class="full-width has-padding has-border" id="signup-username" type="text" placeholder="Username">
						<span class="cd-error-message">Error message here!</span>
					</p>

					<p class="fieldset">
						<label class="image-replace cd-email" for="signup-email">E-mail</label>
						<input class="full-width has-padding has-border" id="signup-email" type="email" placeholder="E-mail">
						<span class="cd-error-message">Error message here!</span>
					</p>

					<p class="fieldset">
						<label class="image-replace cd-password" for="signup-password">Password</label>
						<input class="full-width has-padding has-border" id="signup-password" type="text"  placeholder="Password">
						<a href="javascript:void(0);" class="hide-password">Hide</a>
						<span class="cd-error-message">Error message here!</span>
					</p>

					<p class="fieldset">
						<input type="checkbox" id="accept-terms">
						<label for="accept-terms">I agree to the <a href="javascript:void(0);">Terms</a></label>
					</p>

					<p class="fieldset">
						<input class="full-width has-padding" type="submit" value="Create account">
					</p>
				</form>

				<!-- <a href="javascript:void(0);" class="cd-close-form">Close</a> -->
			</div> <!-- cd-signup -->

			<div id="cd-reset-password"> <!-- reset password form -->
				<p class="cd-form-message">Lost your password? Please enter your email address. You will receive a link to create a new password.</p>

				<form class="cd-form">
					<p class="fieldset">
						<label class="image-replace cd-email" for="reset-email">E-mail</label>
						<input class="full-width has-padding has-border" id="reset-email" type="email" placeholder="E-mail">
						<span class="cd-error-message">Error message here!</span>
					</p>

					<p class="fieldset">
						<input class="full-width has-padding" type="submit" value="Reset password">
					</p>
				</form>

				<p class="cd-form-bottom-message"><a href="javascript:void(0);">Back to log-in</a></p>
			</div> <!-- cd-reset-password -->
			<a href="javascript:void(0);" class="cd-close-form">Close</a>
		</div> <!-- cd-user-modal-container -->
	</div> <!-- cd-user-modal -->
</div><!--/wrapper-->

<!-- Wait Block -->

<!-- End Wait Block -->


</body>
</html>