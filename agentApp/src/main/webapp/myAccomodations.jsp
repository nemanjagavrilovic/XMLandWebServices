<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"	src="${pageContext.request.contextPath}/js/jquery.min.js"> </script>
<script type="text/javascript"	src="${pageContext.request.contextPath}/js/myAccom.js"> </script>
	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accomodations</title>
</head>
<body>

	<div>
		<table>
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
					<tr>
						<td>${accom.name }</td>
						<td>${accom.description }</td>
						<td>${accom.maxPerson }</td>
						<td><a href="../accomodations/accomodation/${accom.id}">View</a>
					</tr>
	
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>