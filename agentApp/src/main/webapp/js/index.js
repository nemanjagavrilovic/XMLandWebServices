$(document).on('click','#login',function(e){
	
	$.ajax({
		url:'/login/signIn',
		type:'GET',
		success:function(data){
			window.top.location=data;
		}
	})
})