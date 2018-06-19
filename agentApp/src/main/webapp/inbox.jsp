<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"	src="${pageContext.request.contextPath}/js/jquery.min.js"> </script>
<script type="text/javascript"	src="${pageContext.request.contextPath}/js/inbox.js"> </script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/inbox.css">
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:import url="_navbar.jsp"></c:import>
<c:if test="${ empty user}">
		<c:redirect url="/index.jsp"></c:redirect>
	</c:if>
	
	<div class="inboxes">
			<c:forEach items="${inboxes}" var="inbox">
			
			<div>
				<a id="link" href="/inbox/${inbox.id}">${inbox.sender.name} ${inbox.sender.surname }</a>
			</div>
			</c:forEach>
		</div>
	<div class="container">
			<div class="messages">
		
			</div>
			<div class="sending"></div>
	</div>
	
</body>
</html>