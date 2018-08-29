<%@ include file="../../layout/taglib.jsp"%>


<c:set var="baseUrl"><tiles:getAsString name='basePaginationUrl' /></c:set>
<c:if test="${not empty page}" >
<fmt:parseNumber var="noLinksPerSide" value="3"/>
<fmt:parseNumber var="nullNo" value="0"/>
<fmt:parseNumber var="firstDisplay" value="1"/>

<!--Pegination Centered-->
<div class="tag-box tag-box-v7 text-justify">
	<div class="text-center">
	
	<ul class="pagination">
	<c:if test="${page.current > firstDisplay}" >
		<li class="previous"><a href="<c:out value='${baseUrl}${page.current - 1}'/>">«</a></li>
	</c:if>
	
	<c:if test="${not empty page.current && not empty totalPages}">
		
		
		<c:if test="${ page.current >=  firstDisplay}" >
			<c:choose>
					<c:when test="${page.current - noLinksPerSide >= firstDisplay}">
						<c:forEach begin="${page.current -  noLinksPerSide}" end="${page.current - 1}" var="val">
						    <li><a href="<c:out value="${baseUrl}${val}" />"><c:out value="${val}"/></a></li>
						</c:forEach>
					</c:when>
					
					<c:otherwise>
					
						<c:forEach begin="${firstDisplay}" end="${page.current - 1}" var="val">
				   			<li><a href="<c:out value="${baseUrl}${val}" />"><c:out value="${val}"/></a></li>
						</c:forEach>
					
					</c:otherwise>
				
				</c:choose>
		</c:if>
		
		
		<li class="active"><a href="<c:out value="${baseUrl}${page.current}" />"><c:out value="${page.current}" /></a></li>
		
		<c:if test="${ page.current <=  totalPages}" >
		
			<c:choose>
					<c:when test="${page.current + noLinksPerSide <= totalPages}">
						<c:forEach begin="${page.current + 1}" end="${page.current +  noLinksPerSide}" var="val">
						    <li><a href="<c:out value="${baseUrl}${val}" />"><c:out value="${val}"/></a></li>
						</c:forEach>
					</c:when>
					<c:otherwise>
					
						<c:forEach begin="${page.current + 1}" end="${totalPages}" var="val">
						    <li><a href="<c:out value="${baseUrl}${val}" />"><c:out value="${val}"/></a></li>
						</c:forEach>
					</c:otherwise>
				</c:choose>
		
		</c:if>
		
		
	</c:if>
	<c:if test="${page.current < totalPages}" >
		<li><a href="<c:out value='${baseUrl}${page.current + 1}'/>">»</a></li>
	</c:if>
	</ul>
	</div>
	
	<hr>
	
	<c:out value="${totalPages}" /> page(s)
	
</div>
<!--End Pegination Centered-->
</c:if>