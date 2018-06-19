$(document).on('click','#login',function(e){
	
	var data=JSON.stringify({
		"email":$("#email").val(),
		"password":$("#password").val()
	})
	$.ajax({
		url:'/login/signIn',
		type:'POST',
		contentType:'application/json',
		dataType:'json',
		data:data,
		success:function(data){
			window.top.location=data;
		},
		error:function(data){
			alert('Pogresan email ili lozinka!')
		}
	})
})
