package com.holiday.agentApp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.holiday.agentApp.client.ArrangmentClient;
import com.holiday.agentApp.requestAndResponse.ArrangmentAllResponse;
import com.holiday.agentApp.requestAndResponse.ArrangmentUpdateResponse;

@Controller
@RequestMapping("/arrangments")
public class ArrangmentsController {
	
	@Autowired
	private ArrangmentClient arrangmentClient;
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String arrangmentsPage(HttpServletRequest request){
		
		JAXBElement<ArrangmentAllResponse> arrangments=arrangmentClient.findAll();
		System.out.println(arrangments.getValue().getArrangment().size());
		request.getSession().setAttribute("arrangments", arrangments.getValue().getArrangment());
		return "forward:/arrangments.jsp";
	}
	
	@RequestMapping(value="/realization/{id}/{realized}",method=RequestMethod.PUT)
	public ResponseEntity<?> notRealized(@PathVariable("id") Long id,@PathVariable ("realized")boolean realized){
		JAXBElement<ArrangmentUpdateResponse> arrangment=arrangmentClient.update(realized, id);
		return new ResponseEntity<Boolean>(realized,HttpStatus.OK);
	}

}
