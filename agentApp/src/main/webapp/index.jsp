<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"	src="${pageContext.request.contextPath}/js/jquery.min.js"> </script>
<script type="text/javascript"	src="${pageContext.request.contextPath}/js/createAcomm.js"> </script>
	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="/accomodations/all">My accomodations</a>
	<div>
		<label>Naziv: </label><input type="text" id="name"><br>
		<label>Opis: </label><input type="text" id="description"><br>
		<label>Tip: </label><select id="objectType"><option id="5">Kuca</option></select><br>
		<label>Kategorija: </label><select id="objectCategory"><option id="2">1 zvezdica</option></select><br>
		<label>Kapacitet: </label><input type="text" id="maxPerson"><br>
		<label>Lokacija: </label><select id="location"></select>
		<input value="Add address manualy" type="button" id="manualAddress"><br>
		<div id="addressDiv"style="display:none">
				<label>Drzava: </label><input type="text" id="country"><br>
				<label>Grad: </label><input type="text" id="city"><br>
				<label>Ulica: </label><input type="text" id="address"><br>
				<input type="button" value="Add address" id="addAddress"> 
		</div> <br>
		<label>Services:</label><select id="services"></select>
		<input type="button" id="addService" value="Add service"><br>
		<select id="myServices"><option id=2>Parking</option></select>
		<div>
		
			<label>Plan cena:</label><br>
			<table border="1" id="priceSchedule">
				<thead>
					<tr>
						<th>From</th>
						<th>To</th>
						<th>Price</th>
					</tr>
				</thead>
			</table><br>
			<label>Pocetak primene:</label><input type="Date" id="dateStart"><br>
			<label>Kraj primene:</label><input type="Date" id="dateEnd"><br>
			<label>Cena: </label><input type="text" id="price"><br>
			<input type="button" id="addPrice"> 
			<label>Slike: </label>
			<input id="imageInput" accept="image/*" multiple type="file" placeholder="Image">
    		<br> <input type="button" value="Aploaduj" onclick="uploadImage()">
    		<div id="images"></div>
	
		</div>
		<input type="button" value="Create accomodation" id="create">
	</div>
</body>
</html>