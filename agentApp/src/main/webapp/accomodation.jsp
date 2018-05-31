<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"	src="${pageContext.request.contextPath}/js/jquery.min.js"> </script>
<script type="text/javascript"	src="${pageContext.request.contextPath}/js/accomodation.js"> </script>
	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accomodations</title>
</head>
<body>

	<div>
		<table>
			<tbody>
					<tr>
						<td>Ime:</td>
						<td>${accom.name }</td>
					</tr>
					<tr>
						<td>Opis:</td>
						<td>${accom.description }</td>
					</tr>
					<tr>
						<td>Kapacitet:</td>
						<td>${accom.maxPerson }</td>
					</tr>
					<tr colspan=2>
						<td><a id="publish" href="../publish/${accom.id }">Publish</a></td>
					</tr>
			</tbody>
		</table>
		<div>
			<c:forEach items="${accom.picture }" var="picture">
				<img  src="${picture.url }">
			</c:forEach>
		</div>
	</div>
</body>
</html>