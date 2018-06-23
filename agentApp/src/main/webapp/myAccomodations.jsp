<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"	src="${pageContext.request.contextPath}/js/jquery.min.js"> </script>
<script type="text/javascript"	src="${pageContext.request.contextPath}/toastr.js"> </script>
<script type="text/javascript"	src="${pageContext.request.contextPath}/js/myAccom.js"> </script>
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/myAccomodations.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/toastr.css">
	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accomodations</title>
</head>
<body>
	<c:import url="_navbar.jsp"></c:import>
	<c:if test="${ empty user}">
		<c:redirect url="/index.jsp"></c:redirect>
	</c:if>
	
	<div>
		<table border="1" class="accomTable">
			<thead>
				<tr>
					<th>Ime</th>
					<th>Opis</th>
					<th>Kapacitet</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${accomodations}" var="accom">
					<tr >
						<td height="10">${accom.name }</td>
						<td height="10">${accom.description }</td>
						<td height="10">${accom.maxPerson }</td>
						<td height="10"><a href="../accomodations/accomodation/${accom.id}">View</a>
						<td height="10"><a id="delete" href="../accomodations/delete/${accom.id}">Delete</a>
					
					</tr>
	
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>