<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../../layout/taglib.jsp" %>

<c:url var="firstUrl" value="/admin/users?page=1" />
<c:url var="lastUrl" value="/admin/users?page=${usersLog.totalPages}" />
<c:url var="prevUrl" value="/admin/users?page=${currentIndex - 1}" />
<c:url var="nextUrl" value="/admin/users?page=${currentIndex + 1}" />


	<h3>List of Users</h3>
	<hr />
	
	
	<div class="panel panel-grey margin-bottom-40">
		<div class="panel-heading">
			<h3 class="panel-title"><i class="fa fa-user"></i>List of Users</h3>
		</div>
		<div class="panel-body">
		
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Id</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Username</th>
						<th>Roles</th>
<!-- 						<th>Profiles</th> -->
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
				
				
				<c:forEach items="${users}" var="user">
					<tr>
						<td>
							${user.id}
						</td>
						<td>
							${user.first_name}
						</td>
						<td>
							${user.last_name}
						</td>
						
						<td>
							${user.username}
						</td>
						
						<td>	
							<ul class="list">
							<c:forEach items="${user.roles}" var="role">
								<li><c:out value="${role.name}"></c:out></li>
							</c:forEach>
							</ul>
						</td>
						
						<%-- <td>	
							<ul class="list">
							<c:forEach items="${user.profiles}" var="profile">
								<li><c:out value="${profile.name}"></c:out></li>
							</c:forEach>
							</ul>
						</td> --%>
						
						<td>
							<a href="<spring:url value='/admin/users/modalView/${user.id}' />" class="btn-u btn-u-blue btn-xs modalOpen noSave"><i class="glyphicon glyphicon-pencil"></i> View</a>
							<a href="<spring:url value='/admin/users/modalEdit/${user.id}' />" class="btn-u btn-u-yellow btn-xs modalOpen"><i class="glyphicon glyphicon-pencil"></i> Edit</a>
							<a href="<spring:url value='/admin/users/delete/${user.id}' />" class="btn-u btn-u-red btn-xs triggerRemove"><i class="glyphicon glyphicon-trash"></i> Remove</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			
		</div>
		
	</div>
	
	<div class="text-center">
    <ul class="pagination">
        <c:choose>
            <c:when test="${currentIndex == 1}">
                <li class="disabled"><a href="#">&lt;&lt;</a></li>
                <li class="disabled"><a href="#">&lt;</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${firstUrl}">&lt;&lt;</a></li>
                <li><a href="${prevUrl}">&lt;</a></li>
            </c:otherwise>
        </c:choose>
        <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
            <c:url var="pageUrl" value="/admin/users?page=${i}" />
            <c:choose>
                <c:when test="${i == currentIndex}">
                    <li class="active"><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:choose>
            <c:when test="${currentIndex == usersLog.totalPages}">
                <li class="disabled"><a href="#">&gt;</a></li>
                <li class="disabled"><a href="#">&gt;&gt;</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${nextUrl}">&gt;</a></li>
                <li><a href="${lastUrl}">&gt;&gt;</a></li>
            </c:otherwise>
        </c:choose>
    </ul>
</div>
	
	
	
	<hr/>
	<a href="<spring:url value='/admin/users/adduser' />" class="btn btn-sm btn-primary"><i class="glyphicon glyphicon-plus"></i> New User</a>