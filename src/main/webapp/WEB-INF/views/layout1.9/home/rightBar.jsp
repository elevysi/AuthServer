<%@ include file="../../layout/taglib.jsp"%>
<c:url var="getLastCommentsUrl" value="/public/latestComments" />

				<!-- Blog Thumb v3 -->
				<div class="row margin-bottom-50">
					<div id="latestComments">
					</div>
				</div>
				<!-- End Blog Thumb v3 -->
				
				

<script type="text/javascript">


$(document).ready(function(){
	var getCommentsUrl = '${getLastCommentsUrl}';
	$("#latestComments").html("");
	$("#latestComments").addClass("loader-256-gray");
	$.ajax({
          type: "GET",
          url: getCommentsUrl,
          dataType : "html",
          success: function(html){
        	  $("#latestComments").html(html);
        	  $("#latestComments").removeClass("loader-256-gray");
          },
          error: function(){
              alert("Failed to load Comments.");
          }
	 });
});

</script>				

