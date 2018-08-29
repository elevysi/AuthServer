<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../../layout/taglib.jsp"%>

<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
	<form:form commandName="user" class="reg-page registrationForm">
		<div class="reg-header">
			<h2>Edit <c:out value="${user.username}"></c:out></h2>
			
		</div>

		<label>First Name <span class="color-red">*</span></label>
		<form:input path="first_name" cssClass="form-control margin-bottom-20" />
		<form:errors path="first_name" />


		<label>Last Name <span class="color-red">*</span></label>
		<form:input path="last_name" cssClass="form-control margin-bottom-20" />
		<form:errors path="last_name" />


		<label>Email Address <span class="color-red">*</span></label>
		<div class="input-group margin-bottom-20">
			<span class="input-group-addon"> <i class="fa fa-envelope"></i></span>
			<form:input path="email" cssClass="form-control margin-bottom-20" />
			<form:errors path="email" />
		</div>

		<label>Username <span class="color-red">*</span></label>
		<div class="input-group margin-bottom-20">
			<span class="input-group-addon"><i class="fa fa-user"></i></span>
			<form:input path="username" cssClass="form-control margin-bottom-20" />
			<form:errors path="username" />
		</div>


		<div class="row">
			<form:checkboxes path="roles" element="label class='checkbox'"
				items="${roles}" itemValue="id" itemLabel="name" />
			<form:errors path="roles" cssClass="error" />
		</div>


		<hr>

		<div class="row">
			
			<div class="col-lg-6 text-right">
				<button class="btn-u" type="submit">Save</button>
			</div>
		</div>
	</form:form>
</div>


<script>
	$(document).ready(
			function() {
				$(".registrationForm").validate(
						{
							rules : {
								username : {
									required : true,
									minlength : 3,
								/* remote : {
									url : "<spring:url value='/register/available.html'/>",
									type : "GET",
									data : {
										username: function(){
											return $("#name").val();
										}
									}
								} */
								},
								email : {
									required : true,
									email : true
								},
								password : {
									required : true,
									minlength : 5
								},
								passwordAgain : {
									required : true,
									minlength : 5,
									equalTo : "#password"
								}
							},
							highlight : function(element) {
								$(element).closest(".form-group").removeClass(
										'has-success').addClass('has-error')
							},
							unhighlight : function(element) {
								$(element).closest(".form-group").removeClass(
										'has-error').addClass('has-success')
							},
							messages : {
								name : {
									remote : "Such a username already exists"
								}
							}
						});
			});
</script>




