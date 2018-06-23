var mysql = require('mysql');
var cors = require('cors')();
exports.helloWorld =  function(req, res) {
	 cors(req, res,()=>{
	var c = mysql.createConnection({
		host     : 'localhost',
     user     : 'root',
      password : 'malizvornik95',
      database: 'xmlNova'
    });
		let value =req.query.value
	let accID =req.query.id
	let userID =req.query.user
	let arrID=req.query.arr
	let ratingID=req.query.ratingID;
	
	c.connect();
	if(ratingID!=0){
			c.query('update rating set rating='+value+' where id='+ratingID+'');
	}else{
		c.query('insert into rating (accomodation_id,rating,owner_id) values('+accID+','+value+','+userID+')',function(err,result){
					 if(err) throw err;
					 ratingID=result.insertId;
					 c.query('insert into accomodation_rating (accomodation_id,rating_id) values ('+accID+','+result.insertId+')',function(err,result){
							if(err) throw err;
							c.query('update arrangment set rating_id='+ratingID+' where id='+arrID+'');
					 });
			
				});
			
	}
	res.status(200);
	});
}
var mysql = require('mysql');
var cors = require('cors')();
exports.getAccRating = function(req,res){
	cors(req,res,()=>{
	var c = mysql.createConnection({
		host     : 'localhost',
     user     : 'root',
      password : 'malizvornik95',
      database: 'xmlNova'
    });
	c.connect();
	let id=req.query.accID;
	c.query('Select * from rating where accomodation_id='+id+'',function(err,result){
			if(err)throw err;
			console.log(result);
			res.status(200).send(result);
		});
	});
	
}
