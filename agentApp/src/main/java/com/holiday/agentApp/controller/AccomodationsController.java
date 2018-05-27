package com.holiday.agentApp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.holiday.agentApp.model.Accomodation;
import com.holiday.agentApp.service.AccomodationService;

@Controller
@RequestMapping("/accomodations")
public class AccomodationsController {

	@Autowired
	private AccomodationService accomodationService;
	
	@RequestMapping("/accomodation/{id}")
	public String getAccomodation(@PathVariable ("id") Long id,HttpServletRequest request){
		Accomodation accom=accomodationService.findById(id);
		request.getSession().setAttribute("accomodation", accom);
		return "forward:/accomodation.jsp";
	}
	
	@RequestMapping("/all")
	public String getAccomodations(HttpServletRequest request){
		List<Accomodation> accoms=accomodationService.findAll();
		request.getSession().setAttribute("accomodations", accoms);
		return "forward:/myAccomodations.jsp";
	}
}
