package com.holiday.agentApp.controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import org.springframework.beans.factory.annotation.Autowired;
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
		String address="http://localhost:9090/Service/AccomodationWebService";
		QName serviceName = new QName("http://webService.agentApp.holiday.com/", "AccomodationWebService");
	        QName portName = new QName("http://webService.agentApp.holiday.com/", "AccomodationWebServiceImplPort");

	        Service service = null;
			try {
				service = Service.create(new URL(address+"?wsdl"), serviceName);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         com.holiday.agentApp.webService.AccomodationWebService client = service.getPort(portName,  com.holiday.agentApp.webService.AccomodationWebService.class);
	        
		Accomodation response= client.findById(id);
		request.getSession().setAttribute("accom", response);
		Accomodation accom=accomodationService.findById(id);
		request.getSession().setAttribute("accom", accom);
		return "forward:/accomodation.jsp";
	}
	
	@RequestMapping("/all")
	public String getAccomodations(HttpServletRequest request){
		List<Accomodation> accoms=accomodationService.findAll();
		request.getSession().setAttribute("accomodations", accoms);
		return "forward:/myAccomodations.jsp";
	}
}
