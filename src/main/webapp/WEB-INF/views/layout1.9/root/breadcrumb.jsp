<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../../layout/taglib.jsp"%>

<tilesx:useAttribute name="currentUrl" ignore="true"/>
<tilesx:useAttribute name="title" ignore="true"/>
<div class="container">
	<h1 class="pull-left">Confetti Bucket</h1>
	<ul class="pull-right breadcrumb">
		<li><a href="<c:url value='/' />">Home</a></li>
		<li class="active"><a href='<c:url value="${currentUrl}" />'><c:out value="${title}" /></a></li>
		
	</ul>
</div><!--/container-->