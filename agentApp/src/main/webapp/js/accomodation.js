$(document).on('click','#publish',function(e){
	e.preventDefault();
	var confirmed=confirm("Da li zelite da objavite smestaj");
	if(confirmed){
		var url=$(this).attr("href")
		$.ajax({
			url:url,
			type:'POST',
			success:function(data){
				alert('Uspesno objavljeno')
			},
			error:function(data){
				alert('Vec je objavljen smestaj.')
			}
		})
	}
})
$(document).on('click','#reserve',function(e){
	$("#reservationModal").modal('toggle')
})
$(document).on('click','#reserveButton',function(e){
	var data=JSON.stringify({
		dateStart:$("#arrForm [name='dateStart']").val(),

		dateEnd:$("#arrForm [name='dateEnd']").val(),

	})
	$.ajax({
		url:'../../arrangments/reserve/'+$("#id").val(),
		type:'POST',
		contentType:'application/json',
		dataType:'json',
		data:data,
		success:function(data){
			alert("Rezervisano")
		}
	})
})
