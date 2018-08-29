<%@ include file="../../layout/taglib.jsp"%>

		<div class="master-slider ms-skin-default" id="masterslider">
		
			<c:forEach items="${sliderPosts}" var="sliderPost">
			
				<div class="ms-slide blog-slider">
					<img src="<c:url value='/uploads/download?key=${sliderPost.imageKey}'/>" data-src="<c:url value='/uploads/download?key=${sliderPost.imageKey}'/>" alt="">
					<c:choose>
						<c:when test="${not empty sliderPost.postCategory}">
							<span class="blog-slider-badge"><c:out value="${sliderPost.postCategory}"/></span>
						</c:when>
					</c:choose>
					
					
					<div class="ms-info"></div>
					<div class="blog-slider-title">
						<span class="blog-slider-posted"><c:out value="${sliderPost.created}" /></span>
						<h2><a href="<spring:url value='/posts/view/${sliderPost.id}/${sliderPost.slug}'/>"><c:out value="${sliderPost.title}"/></a></h2>
					</div>
				</div>
			
			</c:forEach>
		</div>