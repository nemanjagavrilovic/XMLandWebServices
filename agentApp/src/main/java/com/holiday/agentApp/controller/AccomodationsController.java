package com.holiday.agentApp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.holiday.agentApp.client.AccomodationClient;
import com.holiday.agentApp.model.Accomodation;
import com.holiday.agentApp.model.TUser;
import com.holiday.agentApp.requestAndResponse.AccomodationFindByOwnerResponse;
import com.holiday.agentApp.requestAndResponse.AccomodationFindResponse;
import com.holiday.agentApp.service.AccomodationService;

@Controller
@RequestMapping("/accomodations")
public class AccomodationsController {

	@Autowired
	private AccomodationService accomodationService;
	
	@Autowired
	private AccomodationClient accomodationClient;
	@RequestMapping("/accomodation/{id}")
	public String getAccomodation(@PathVariable ("id") Long id,HttpServletRequest request){
	        
		Accomodation response= accomodationService.findById(id);
		request.getSession().setAttribute("accom", response);
		return "forward:/accomodation.jsp";
	}
	
	@RequestMapping("/all")
	public String getAccomodations(HttpServletRequest request){
		
		List<Accomodation> accoms=accomodationService.findAll();
		request.getSession().setAttribute("accomodations", accoms);
		return "forward:/myAccomodations.jsp";
	}
	@RequestMapping("/publish/{id}")
	public ResponseEntity<?> publish(@PathVariable("id") Long id){
		
		Accomodation ac=accomodationService.findById(id);
		System.out.println(ac.getPriceShedule().getPrice().size());
		JAXBElement<AccomodationFindResponse> saved=accomodationClient.find(ac);
		if(saved.getValue().getAccomodation()!=null){
			 return new ResponseEntity<Accomodation>(ac,HttpStatus.BAD_REQUEST);

		}else{
				accomodationClient.save(ac);
			return new ResponseEntity<Accomodation>(ac,HttpStatus.OK);
		}
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		accomodationService.delete(id);
		return new ResponseEntity<Long>(id,HttpStatus.OK);
	}
}
