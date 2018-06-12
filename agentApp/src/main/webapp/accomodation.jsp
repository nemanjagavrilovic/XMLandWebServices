<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"	src="${pageContext.request.contextPath}/js/jquery.min.js"> </script>
<script type="text/javascript"	src="${pageContext.request.contextPath}/js/accomodation.js"> </script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/accomodation.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accomodations</title>
</head>
<body>
	<c:import url="_navbar.jsp"></c:import>
	<div class="topPart">
		<div>
		<table border="1" class="accomTable">
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
						<td >${accom.maxPerson }</td>
					</tr>
					<tr>
						<td>Lokacija:</td>
						<td>${accom.location.street },${accom.location.city },${accom.location.country } </td>
					</tr>
					<tr>
						<td>Kategorija:</td>
						<td>${accom.category.category }</td>
					</tr>
					<tr>
						<td>Tip:</td>
						<td>${accom.type.type }</td>
					</tr>
					<tr >
						<td><a id="publish" href="../publish/${accom.id }">Publish</a></td>
						<td><a id="reserve" >Reserve</a></td>
				
					</tr>
				
			</tbody>
		</table>
		<div  class="container">
			<c:forEach items="${accom.picture }" var="picture" varStatus="loop">
				<div class="mySlides">
					<div class="numbertext">${loop.index+1}/${fn:length(accom.picture)}</div>
						<img  src="${picture.url }" class="image">
				</div>
			</c:forEach>
			<a class="prev" onclick="plusSlides(-1)">&#10094;</a>
 			<a class="next" onclick="plusSlides(1)">&#10095;</a>
		
			<div class="row">
				<c:forEach items="${accom.picture }" var="picture" varStatus="loop">
				<div class="column" style="width:${150/fn:length(accom.picture)}%">
					 <img class="demo cursor"  src="${picture.url }" onclick="currentSlide(${loop.index+1})" >
				</div>
			</c:forEach>
			</div>
		</div>
		</div>
		<div class="comments">
			<c:forEach items="${accom.comment }" var="comment">
				<div class="panel panel-primary" style="width:400px;height:100px;overflow:auto;top:100px;">
					<div class="panel-heading">${comment.author.name} ${comment.author.surname}</div>
					<div class="panel-body" style="max-width:500px;overflow:auto">${comment.content }</div>
				</div>
		
			</c:forEach>
	
		</div>
	
	</div>
	<div class="modal fade" id="reservationModal" tabindex="-1" role="dialog">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Arrangment</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		    <form id="arrForm" style="display:block;">
		      <div class="modal-body">
		      			<input type="Date" name="dateStart">
		      			<input type="Date" name="dateEnd">
		      			<input type="hidden" value="${accom.id }" id="id">
		      </div>
		      <div class="modal-footer">
		        <button type="button" id="reserveButton" data-dismiss="modal">Reserve</button>
		       
		      </div>
		      </form>
		     
		    </div>
		  </div>
		</div>
</body>
<script>
var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
	  var i;
	  var slides = document.getElementsByClassName("mySlides");
	  var dots = document.getElementsByClassName("demo");
	  var captionText = document.getElementById("caption");
	  if (n > slides.length) {slideIndex = 1}
	  if (n < 1) {slideIndex = slides.length}
	  for (i = 0; i < slides.length; i++) {
	      slides[i].style.display = "none";
	  }
	  for (i = 0; i < dots.length; i++) {
	      dots[i].className = dots[i].className.replace(" active", "");
	  }
	  slides[slideIndex-1].style.display = "block";
	  dots[slideIndex-1].className += " active";
	 
	}
</script>
</html>