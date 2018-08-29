<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../../layout/taglib.jsp"%>
<c:url var="userPassUpdate" value="/updatePassword" />

	<form:form method="post" class="reg-page updatePassForm" action="${userPassUpdate}">
		<div class="reg-header">
			<h2>Update your password</h2>
			
		</div>
		
		<div class="form-item">
			<label>Current Password<span class="color-red">*</span> </label>
			<input type="password" name="currentPassword" class="form-control margin-bottom-20" minlength="5" required="required"/>
		</div>


		<div class="row">
			<div class="col-sm-6 form-item">
				<label>Password <span class="color-red">*</span></label>
				<div class="input-group margin-bottom-20">
					<span class="input-group-addon"> <i class="fa fa-lock"></i></span>
					<input type="password" id="newPassword" name="newPassword" class="form-control margin-bottom-20" minlength="5" required="required"/>
					
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
			
			<div class="col-lg-6 text-right">
				<button class="btn-u" type="submit">Update</button>
			</div>
		</div>

	</form:form>


<script>
$(document).ready(function(){
	$(".updatePassForm").validate(
		{	
			rules : {
				newPassword: {
					required : true,
					minlength : 5
				},
				passwordAgain: {
					required : true,
					minlength : 5,
					equalTo : "#newPassword"
				}
			},
			highlight:function(element){
				$(element).closest(".form-item").removeClass('has-success').addClass('has-error')
			},
			unhighlight:function(element){
				$(element).closest(".form-item").removeClass('has-error').addClass('has-success')
			}
		}
	);
});

</script>




