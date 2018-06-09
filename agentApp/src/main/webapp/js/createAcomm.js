var locationAccom;
var type;
var category;
var services;
var priceShedule;
var prices=[];
var urls=[]
$(document).on('click',"#manualAddress",function(e){
	if(document.getElementById("addressDiv").style.display=="block")
	 document.getElementById("addressDiv").style.display = "none";
	else
		 document.getElementById("addressDiv").style.display = "block";
	
})
$(document).on('click','#addAddress',function(e){
	var country=$("#country").val()
	var city=$("#city").val()
	var address=$("#address").val()
	getServices()
	var data=JSON.stringify({
		"country":country,
		"city":city,
		"street":address
		
	})
	console.log(data)
	$.ajax({
		type:'POST',
		url:'../createAccomodation/addLocation',
		contentType:'application/json',
		dataType:'json',
		data:data,
		success:function(data){
			$("#location").append("<option id=\'"+data.id+"\'>"+data.country+"</option>")
		}
			
	})
})
$(document).on('click','#addPrice',function(e){
	var startDate=$("#dateStart").val()
	var endDate=$("#dateEnd").val()
	var price=$("#price").val()
	
	var data=JSON.stringify({
		"dateStart":startDate,
		"dateEnd":endDate,
		"value":price
	})
	
	$.ajax({
		type:'POST',
		url:'../createAccomodation/addPrice',
		dataType:'json',
		contentType:'application/json',
		data:data,
		success:function(data){
			var row="<tr id=\'"+data.id+"\'><td class='dateStart'>"+convertDate(data.dateStart)+"</td><td class='dateEnd'>"+convertDate(data.dateEnd)+"</td><td class='value'>"+data.value+"</td>" +
					"<td><a id='delete' href=\'../createAccomodation/deletePrice/"+data.id+"\'>Delete</a></td></tr>"
			$("#priceSchedule").append(row)
		}
	})
	
})
$(document).on('click',"#create",function(e){
	getObjectType()
	getObjectCategory()
	getLocation()
	getServices()
	var accomodationID=0;
	var accomodation=JSON.stringify({
		"name":$("#name").val(),
		"description":$("#description").val(),
		"type":type,
		"category":category,
		"maxPerson":$("#maxPerson").val(),
		"location":locationAccom,
		"services":services,
		
	})
	$.ajax({
		type:'POST',
		url:'../createAccomodation/create',
		contentType:'application/json',
		dataType:'json',
		data:accomodation,
		async:false,
		success:function(data){
			accomodationID=data.id
		}
	})
	getPriceShedule()
	$.ajax({
		url:'../createAccomodation/setPriceShedule/'+accomodationID,
		type:'POST',
		contentType:'application/json',
		dataType:'json',
		data:JSON.stringify({
			"price":prices
		}),
		success:function(data){
			alert("Assigned")
		}
	})
	setPictures(accomodationID)
})
function getObjectType(){
	
	$.ajax({
		url:'../createAccomodation/getObjectType/'+$("#objectType option:selected").attr("id"),
		type:'GET',
		async:false,
		success:function(data){
			type= data;
		}
		
	})
	
}
function getObjectCategory(){
	
	$.ajax({
		url:'../createAccomodation/getObjectCategory/'+$("#objectCategory option:selected").attr("id"),
		type:'GET',
		async:false,
		success:function(data){
			category= data;
		}
		
	})

}
function getLocation(){
	
	$.ajax({
		url:'../createAccomodation/getLocation/'+$("#location option:selected").attr("id"),
		type:'GET',
		async:false,
		success:function(data){
			locationAccom= data;
		}
		
	})
	
}
function getServices(){
	
	var ids=[]
	$("#myServices option").each(function(){
		ids.push($(this).attr("id"))
	})
	
	$.ajax({
		type:'POST',
		url:'../createAccomodation/getServices',
		data:JSON.stringify({
			"array":ids,
		}),
		contentType:'application/json',
		dataType:'json',
		async:false,
		success:function(data){
			services= data
		}
	})
	
}
function getPriceShedule(){
	
	$("#priceSchedule tr").not("thead tr").each(function(){
		var price=JSON.stringify({
		"dateStart":$(this).find(".dateStart").html(),
		"dateEnd":$(this).find(".dateEnd").html(),
		"value":$(this).find(".value").html()
		
		})
		prices.push(price)
	})
	
}
function uploadImage() {
	let images = $('#imageInput').prop('files');
    for(i=0;i<images.length;i++){
    	 	let formData = new FormData();
    	    formData.append("image", images[i]);
    	   
		    $.ajax({
		        method: 'POST',
		        headers: {
		            'Authorization': 'Client-ID 27cd31e890a2903',
		            'Accept': 'application/json'
		        },
		        url: 'https://api.imgur.com/3/image',
		        data: formData,
		        processData: false,
		        contentType: false,
		        mimeType: 'multipart/form-data',
		        success: function(data) {
		            image_url = JSON.parse(data).data.link;
		            $("#images").append("<img src=\'"+image_url+"\'/>")
		            var picture=JSON.stringify({
		            	"url":image_url
		            })
		            urls.push(picture)
		            alert("Uspesno aploadovana.");
		            
		        },
		        error: function(data) {
		            console.log(data);
		            alert("Neuspesno.");
		        }
		    });
    }
    
}

function setPictures(accomodationID){
	$.ajax({
		url:'../createAccomodation/setPictures/'+accomodationID,
		type:'POST',
		contentType:'application/json',
		dataType:'json',
		async:false,
		data:JSON.stringify({
			"picture":urls
		}),
		success:function(data){
			console.log("Super")
		}
	})
}
$(document).on('click','#addService',function(e){
	var item=$("#services option:selected")
	$("#services option:selected").remove()
		
	for(i=0;i<item.length;i++){
			$("#myServices").append("<option  id=\'"+item[i].id+"'>"+item[i].text+"</option>")
	}
})
$(document).on('click','#removeService',function(e){
	var item=$("#myServices option:selected")
	$("#myServices option:selected").remove()
	for(i=0;i<item.length;i++){
		$("#services").append("<option  id=\'"+item[i].id+"'>"+item[i].text+"</option>")
	}
})
function convertDate(date) {
var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

if (month.length < 2)
    month = '0' + month;
if (day.length < 2)
    day = '0' + day;
var date = new Date();
date.toLocaleDateString();

return [day, month, year].join('-');
}
$(document).on('change','#dateStart',function(e){
	var date =new Date($('#dateStart').val())
	var now= date.toISOString().slice(0,10)
	$('#dateEnd').prop('min', now);

})
$(document).on('click','#delete',function(e){
	e.preventDefault();
	url=$(this).attr('href')
	id=url.substring(url.lastIndexOf('/')+1,url.length)
	$("#"+id).remove();
	$.ajax({
		url:url,
		type:'DELETE',
		success:function(data){
			
		}
	})
})