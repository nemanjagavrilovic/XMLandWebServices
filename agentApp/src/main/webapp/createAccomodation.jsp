<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"	src="${pageContext.request.contextPath}/js/jquery.min.js"> </script>
<script type="text/javascript"	src="${pageContext.request.contextPath}/js/createAcomm.js"> </script>
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/createAccomodation.css">
	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:import url="_navbar.jsp"></c:import>
	<div class="center">
		
		<label>Naziv: </label><input type="text" class="form-control" id="name"><br>
		<label>Opis: </label><input type="text" class="form-control" id="description"><br>
		<label>Tip: </label><select class="form-control" id="objectType">
		<c:forEach items="${types}" var="type">
				<option id=${type.id }>${type.type }</option>
			</c:forEach>
		
		</select><br>
		<label>Kategorija: </label>
		<select class="form-control" id="objectCategory">
		<c:forEach items="${categories}" var="category">
				<option id=${category.id }>${category.category }</option>
			</c:forEach>
		</select><br>
		<label>Kapacitet: </label><input class="form-control" type="text" id="maxPerson"><br>
		<label>Lokacija: </label>
		<select class="form-control" id="location">
			<c:forEach items="${locations}" var="location">
				<option id=${location.id }>${location.street },${location.city },${location.country}</option>
			</c:forEach>
		</select>
		<input value="Dodaj adresu rucno" type="button" class="btn btn-primary" id="manualAddress"><br>
		<div id="addressDiv"style="display:none">
				<label>Drzava: </label><input class="form-control" type="text" id="country"><br>
				<label>Grad: </label><input  class="form-control" type="text" id="city"><br>
				<label>Ulica: </label><input class="form-control" type="text" id="address"><br>
				<input type="button" class="btn btn-primary" value="Dodaj" id="addAddress"> 
		</div> 
			<div class="services">
				
				<div class="services">
				
				<select id="services" multiple="multiple" size="5" class="form-control">
					<c:forEach items="${services}"  var="service">
						<option id=${service.id }>${service.service }</option>
					</c:forEach>
			
				</select>
				</div>
				<div class="services">
					<input type="button" id="addService" class="btn btn-primary" value="Dodaj">
					<input type="button" id="removeService" class="btn btn-danger" value="Obrisi">
				</div>
				<div class="services ">
						<select id="myServices" class="myServices" multiple="multiple" size="5" class="form-control"></select>
			
				</div>
			</div>
		<div>
			<br><br>
			<div class="priceTable">
			<label>Plan cena:</label><br>
			<table border="1" id="priceSchedule" >
				<thead>
					<tr>
						<th>Od</th>
						<th>Do</th>
						<th>Cena</th>
						<th></th>
					</tr>
				</thead>
			</table><br>
			</div>
			<div class="services">			
				<label>Pocetak primene:</label><input class="form-control" type="Date" id="dateStart"><br>
				<label>Kraj primene:</label><input class="form-control"   type="Date" id="dateEnd"><br>
				<label>Cena: </label><input class="form-control" type="text" id="price"><br>
				<input type="button" value="Dodaj cenu" class="btn btn-primary" id="addPrice"> <br>
			</div>
		</div>
		
			<br class="clearBoth">
			<label>Slike: </label>
			<input id="imageInput" accept="image/*" multiple type="file" placeholder="Image">
    		<br> <input type="button" value="Aploaduj" class="btn btn-primary" onclick="uploadImage()">
    		<div id="images"></div>
	
		<input type="button" class="btn btn-success" value="Kreiraj smestaj" id="create">
	</div>
</body>
</html>