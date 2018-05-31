package com.holiday.agentApp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.holiday.agentApp.model.Arrangment;
import com.holiday.agentApp.service.ArrangmentService;

@Controller
@RequestMapping("/arrangments")
public class ArrangmentsController {
	
	@Autowired
	private ArrangmentService arrangmentService;
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String arrangmentsPage(HttpServletRequest request){
		
		List<Arrangment> arrangments=arrangmentService.findAll();
		System.out.println(arrangments.size());
		request.getSession().setAttribute("arrangments", arrangments);
		return "forward:/arrangments.jsp";
	}

}
