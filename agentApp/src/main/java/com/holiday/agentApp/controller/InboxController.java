package com.holiday.agentApp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.holiday.agentApp.model.Inbox;
import com.holiday.agentApp.service.InboxService;
import com.holiday.agentApp.service.MessageService;
import com.holiday.agentApp.service.UserService;

@Controller
@RequestMapping("/inbox")
public class InboxController {

	@Autowired
	private InboxService inboxService;
	
	@Autowired
	private UserService userService;
	@Autowired
	private MessageService messageService;
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String inboxHome(HttpServletRequest request,@PathVariable ("id") Long senderId){
		
		
		Inbox inbox=inboxService.findBySenderAndReceiver(userService.findById(senderId),userService.findById(1L));
		System.out.println(inbox.getReceiver().getId());
		System.out.println(	inbox.getMessage().size());
	
		request.getSession().setAttribute("messages", messageService.findByInbox(inbox));
		return "forward:/inbox.jsp";
	}
	
}
