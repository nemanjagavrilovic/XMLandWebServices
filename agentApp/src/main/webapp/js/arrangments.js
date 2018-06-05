$(document).on('click','#notRealized',function(e){
	e.preventDefault();
	url=$(this).attr('href')
	urlParts=url.split('/')
	newUrl=urlParts[0]+"/"+urlParts[1]+"/"+urlParts[2]+"/"+urlParts[3]+"/"+"true"
	
	link=$(this)
	
	$.ajax({
		url:url,
		type:'PUT',
		success:function(data){
			if(data==false)
				link.text("Not Realized")
				link.attr('href',newUrl)
				link.attr('id','realized')
				
		}
	})
})
$(document).on('click','#realized',function(e){
	e.preventDefault();
	url=$(this).attr('href')
	link=$(this)
	urlParts=url.split('/')
	newUrl=urlParts[0]+"/"+urlParts[1]+"/"+urlParts[2]+"/"+urlParts[3]+"/"+"false"
	$.ajax({
		url:url,
		type:'PUT',
		success:function(data){
			if(data==true)
				link.text("Realized")
				link.attr('href',newUrl)
				link.attr('id','notRealized')
				
		}
	})
})