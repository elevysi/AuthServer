<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../../layout/taglib.jsp"%>
<c:url var="userRegister" value="/register" />

	<form:form commandName="user"  method="post" class="reg-page registrationForm" action="${userRegister}">
		<div class="reg-header">
			<h2>Register a new account</h2>
			<p>
				Already Signed Up? Click <a href="<c:url value='/login'/>"
					class="color-green">Sign In</a> to login your account.
			</p>
		</div>
		
		<div class="form-item">
			<label>First Name <span class="color-red">*</span> <form:errors path="first_name" /></label>
			<form:input path="first_name" cssClass="form-control margin-bottom-20" minlength="3" required="required"/>
		</div>

		<div class="form-item">
			<label>Last Name <span class="color-red">*</span> <form:errors path="last_name" /></label>
			<form:input path="last_name" cssClass="form-control margin-bottom-20" minlength="3" required="required"/>
		</div>

		<div class="form-item">
			<label>Email Address <span class="color-red">*</span> <form:errors path="email" /></label>
			<div class="input-group margin-bottom-20">
				<span class="input-group-addon"> <i class="fa fa-envelope"></i></span>
				<form:input path="email" cssClass="form-control margin-bottom-20" minlength="3" required="required" type="email"/>
				
			</div>
		</div>

		<div class="form-item">
			<label>Username <span class="color-red">*</span> <form:errors path="username" /></label>
			<div class="input-group margin-bottom-20">
				<span class="input-group-addon"><i class="fa fa-user"></i></span>
				<form:input path="username" cssClass="form-control margin-bottom-20" minlength="3" required="required"/>
				
			</div>
		</div>

		<div class="row">
			<div class="col-sm-6 form-item">
				<label>Password <span class="color-red">*</span> <form:errors path="password" /></label>
				<div class="input-group margin-bottom-20">
					<span class="input-group-addon"> <i class="fa fa-lock"></i></span>
					<form:password path="password"
						cssClass="form-control margin-bottom-20" minlength="5" required="required"/>
					
				</div>
			</div>
			<div class="col-sm-6 form-item">
				<label>Confirm Password <span class="color-red">*</span></label>
				<div class="input-group margin-bottom-20">
					<span class="input-group-addon"> <i class="fa fa-key"></i></span> <input
						type="password" name="passwordAgain" id="passwordAgain"
						class="form-control margin-bottom-20">
				</div>
			</div>
		</div>

		<hr>

		<div class="row">
			<div class="col-lg-6">
				<label class="checkbox"> <input type="checkbox"> I
					read <a href="page_terms.html" class="color-green">Terms and
						Conditions</a>
				</label>
			</div>
			<div class="col-lg-6 text-right">
				<button class="btn-u" type="submit">Register</button>
			</div>
		</div>
	</form:form>


<script>
$(document).ready(function(){
	$(".registrationForm").validate(
		{	
			rules : {
				username: {
					required : true,
					minlength : 3,
					remote : {
						url : "<spring:url value='/register/usernameAvailable'/>",
						type : "GET",
						data : {
							username: function(){
								return $("#username").val();
							}
						}
					}
				},
				first_name: {
					required : true,
					minlength : 3
				},
				last_name: {
					required : true,
					minlength : 3
				},
				email: {
					required : true,
					email : true,
					remote : {
						url : "<spring:url value='/register/emailRegistered'/>",
						type : "GET",
						data : {
							username: function(){
								return $("#email").val();
							}
						}
					}
				},
				password: {
					required : true,
					minlength : 5
				},
				passwordAgain: {
					required : true,
					minlength : 5,
					equalTo : "#password"
				}
			},
			highlight:function(element){
				$(element).closest(".form-item").removeClass('has-success').addClass('has-error')
			},
			unhighlight:function(element){
				$(element).closest(".form-item").removeClass('has-error').addClass('has-success')
			},
			messages :{
				username : {
					remote : "Such a username already exists"
				}
			}
		}
	);
});

</script>




