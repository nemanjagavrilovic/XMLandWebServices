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
			}
		})
	}
})