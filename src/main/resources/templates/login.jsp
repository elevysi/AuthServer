<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../../layout/taglib.jsp" %>


<c:choose>
     <c:when test="${loginRequestMapCode == 1}">
         <c:url var="loginFormPostActionUrl" value="/auth/rqstd/doLogIn" />
     </c:when>
     <c:otherwise>
         <c:url var="loginFormPostActionUrl" value="/login" />
     </c:otherwise>
 </c:choose>

	<!--Reg Block-->
	<div class="reg-block">
	
	<form class="reg-page" action="${loginFormPostActionUrl}" method="POST">
	
	<input type="hidden" name="grant_type" value="password">
	<input type="hidden" name="scope" value="read">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	
		<div class="reg-block-header">
			<h2><spring:message code="label.login.title" /></h2>
			<ul class="social-icons text-center">
				<li><a class="rounded-x social_facebook"
					data-original-title="Facebook" href="#"></a></li>
				<li><a class="rounded-x social_twitter"
					data-original-title="Twitter" href="#"></a></li>
				<li><a class="rounded-x social_googleplus"
					data-original-title="Google Plus" href="#"></a></li>
				<li><a class="rounded-x social_linkedin"
					data-original-title="Linkedin" href="#"></a></li>
			</ul>
			<p>
				<spring:message code="label.login.explanation1" /> <a class="color-green" href="<c:url value='/register'/>"><spring:message code="label.login.explanation.link" /></a> <spring:message code="label.login.explanation2" />
			</p>
			<p class="message">${message}</p>
			
			<c:if test="${sessionMessage.msgText != null}">
				<div class="${sessionMessage.msgClass}">
					<button class="close" aria-hidden="true" data-dismiss="alert" type="button">×</button>
					<c:out value="${sessionMessage.msgText}"></c:out>
				</div>
			</c:if>
		</div>
		
		<div class="input-group margin-bottom-20">
			<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
			<input type="text" class="form-control" placeholder="Email" name="username">
		</div>
		<div class="input-group margin-bottom-20">
			<span class="input-group-addon"><i class="fa fa-lock"></i></span> 
			<input type="password" class="form-control" placeholder="Password" name="password">
		</div>
		<hr>
		<label class="checkbox"> <input type="checkbox" name="remember-me">
			<p><spring:message code="label.login.remember" /></p>
		</label>
	
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<button type="submit" class="btn-u btn-block"><spring:message code="label.login.signInButton" /></button>
			</div>
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>
		
		<hr>
		
		<div class="text-center"><a href="<spring:url value="/"/>"><spring:message code="label.login.homePageLink" /></a></div>
	</div>
	<!--End Reg Block-->