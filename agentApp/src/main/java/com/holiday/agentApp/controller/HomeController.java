package com.holiday.agentApp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.holiday.agentApp.model.Agent;
import com.holiday.agentApp.service.LocationService;
import com.holiday.agentApp.service.UserService;
@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	@Autowired
	private LocationService locationService;
	@RequestMapping("/")
	public String getHomePage(){
		Agent agent=new Agent();
		agent.setEmail("email");
		agent.setLocation(locationService.findById(14L));
		agent.setName("Nemanja");
		agent.setSurname("Gavrilovic");
		agent.setPassword("123");
		agent.setPMB("PBM");
		userService.save(agent);
		return "forward:/index.jsp";
	}
}
