$(document).on('click','#login',function(e){
	
	var data=JSON.stringify({
		"email":$("#email").val(),
		"password":$("#password").val()
	})
	$.ajax({
		url:'/agent2/login/signIn',
		type:'POST',
		contentType:'application/json',
		dataType:'json',
		data:data,
		success:function(data){
			window.top.location=data;
		},
		error:function(data){
			toastr.error('Pogresan email ili loznika!')
		}
	})
})
