$(document).on('click','#link',function(e){
	e.preventDefault();
	url=$(this).attr('href');
	inboxId=url.substring(url.lastIndexOf('/')+1,url.length)
	$.ajax({
		url:url,
		type:'GET',
		success:function(data){
			$('.messages').empty()
			$.each(data,function(index,item){
				drawMessage(index,item);
			})
			$('.sending').empty()
			$('.sending').append(
					"<div class=\"bottomOfMessage\">" +
					"<input type=\'text\' class=\'sendText \' id=\'content\'>" +
					'<input type="button" value="Send" class=\'btn btn-primary\' onClick="sendMessage(\'' + inboxId + '\')"/></div>')
		}
	})
})
function drawMessage(index,item){
	if(item.sentBy.email=='nemanja.gavrilovic1995@gmail.com'){
		$(".messages").append('<br><br><div class=sent>'+item.content+'</div>')
	}else{
		$(".messages").append('<br><br><div class=received>'+item.content+'</div>')

	}
}
function sendMessage(inboxId){
	var data=JSON.stringify({
		"content":$("#content").val()
	})
	$.ajax({
		url:'../inbox/sendMessage/'+inboxId,
		type:'POST',
		data:data,
		contentType:'application/json',
		dataType:'json',
		success:function(data){
			$(".messages").append('<br><br><div class=sent>'+data.content+'</div>')
		}
	})

}