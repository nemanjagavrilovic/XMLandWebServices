<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"	src="${pageContext.request.contextPath}/js/jquery.min.js"> </script>
<script type="text/javascript"	src="${pageContext.request.contextPath}/js/arrangments.js"> </script>
	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<table border=2>
		<thead>
			<tr>
				<th>Korisnik:</th>
				<th>Od:</th>
				<th>Do:</th>
				<th>Smestaj:</th>
				<th>Realizovan:</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${arrangments}" var="arrangment">
				<tr>
					<td>${arrangment.owner.username }</td>
					<td>${arrangment.dateStart }</td>
					<td>${arrangment.dateEnd }</td>
					<td>${arrangment.accomodation.name }</td>
					<td>
					<c:if test="${arrangment.realized==true}">
						<a id="notRealized" href="../arrangments/realization/${arrangment.id }/false">Realized</a>
					</c:if>
					<c:if test="${arrangment.realized==false }">
						<a id="realized" href="../arrangments/realization/${arrangment.id}/true">Not realized</a>
				
					</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>