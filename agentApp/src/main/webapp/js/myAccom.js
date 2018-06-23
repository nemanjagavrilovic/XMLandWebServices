$(document).on('click','#delete',function(e){
	e.preventDefault();
	url=$(this).attr('href');
	var confirmed=confirm("Da li ste sigurni da zelite da izbrisete smestaj");
	if(confirmed==true){
		row=$(this)
		$.ajax({
			url:url,
			type:'DELETE',
			success:function(data){
				toastr.success('Uspesno obrisano')
				row.parent().parent().remove()
			},
			error:function(d,e,e){
				toastr.warning('Postoji rezervacija za ovaj smestaj')
			}
			})
	}
})