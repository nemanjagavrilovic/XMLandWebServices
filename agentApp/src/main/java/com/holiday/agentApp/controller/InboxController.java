package com.holiday.agentApp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.holiday.agentApp.model.Inbox;
import com.holiday.agentApp.model.Message;
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
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String inboxHome(HttpServletRequest request){
		
		
		request.getSession().setAttribute("inboxes", inboxService.findByReceiver(userService.findById(1L)));
		
		return "forward:/inbox.jsp";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<List<Message>> findInbox(@PathVariable ("id") Long id){
		
		Inbox inbox=inboxService.findById(id);
		System.out.println(inbox.getReceiver().getId());
		System.out.println(	inbox.getMessage().size());
	
		List<Message> messages= messageService.findByInbox(inbox);
		
		return new ResponseEntity<List<Message>>(messages,HttpStatus.OK);
	}

	
}
