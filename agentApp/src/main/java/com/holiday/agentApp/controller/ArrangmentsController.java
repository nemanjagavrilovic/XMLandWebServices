package com.holiday.agentApp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.holiday.agentApp.client.AccomodationClient;
import com.holiday.agentApp.client.ArrangmentClient;
import com.holiday.agentApp.model.Accomodation;
import com.holiday.agentApp.model.Arrangment;
import com.holiday.agentApp.model.TUser;
import com.holiday.agentApp.requestAndResponse.AccomodationFindResponse;
import com.holiday.agentApp.requestAndResponse.ArrangmentFindResponse;
import com.holiday.agentApp.requestAndResponse.ArrangmentUpdateResponse;
import com.holiday.agentApp.service.AccomodationService;
import com.holiday.agentApp.service.ArrangmentService;

@Controller
@RequestMapping("/arrangments")
public class ArrangmentsController {
	
	@Autowired
	private ArrangmentClient arrangmentClient;
	
	@Autowired
	private AccomodationClient accomodationClient;
	
	@Autowired
	private ArrangmentService arrangmentService;
	@Autowired
	private AccomodationService accomodationService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String arrangmentsPage(HttpServletRequest request){
		
		
		request.getSession().setAttribute("arrangments",arrangmentService.findAll() );
		return "forward:/arrangments.jsp";
	}
	
	@RequestMapping(value="/realization/{id}/{realized}",method=RequestMethod.PUT)
	public ResponseEntity<?> notRealized(@PathVariable("id") Long id,@PathVariable ("realized")boolean realized){
		Arrangment arrangment=arrangmentService.findOne(id);
		arrangmentService.update(realized, id);
		JAXBElement<AccomodationFindResponse> bigDataBaseAccomodation=accomodationClient.find(arrangment.getAccomodation());
		arrangment.setAccomodation(bigDataBaseAccomodation.getValue().getAccomodation());
		JAXBElement<ArrangmentFindResponse> found=arrangmentClient.find(arrangment);
		JAXBElement<ArrangmentUpdateResponse> update=arrangmentClient.update(realized, found.getValue().getArrangment().getId());
		return new ResponseEntity<Boolean>(realized,HttpStatus.OK);
	}

	@RequestMapping(value="/reserve/{id}",method=RequestMethod.POST)
	public ResponseEntity <?> reserve(@PathVariable("id") Long id,@RequestBody Arrangment arrangment,HttpServletRequest request){
		TUser user=(TUser)request.getSession().getAttribute("user");
		Accomodation accomodation=accomodationService.findById(id);
		JAXBElement<AccomodationFindResponse> bigDataBaseAccomodation=accomodationClient.find(accomodation);
		arrangment.setOwner(user);
		arrangment.setAccomodation(accomodation);
		arrangment.setNumberOfPeople(accomodation.getMaxPerson());
		arrangmentService.save(arrangment);
		
		System.out.println("Smestaj"+bigDataBaseAccomodation.getValue().getAccomodation());
		arrangment.setAccomodation(bigDataBaseAccomodation.getValue().getAccomodation());
		arrangment.setNumberOfPeople(bigDataBaseAccomodation.getValue().getAccomodation().getMaxPerson());
		
		arrangmentClient.save(arrangment);
		return new ResponseEntity<>(null,HttpStatus.CREATED);
	}
}
