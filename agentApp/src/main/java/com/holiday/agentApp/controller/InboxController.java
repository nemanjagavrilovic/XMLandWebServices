package com.holiday.agentApp.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.holiday.agentApp.client.InboxClient;
import com.holiday.agentApp.client.MessageClient;
import com.holiday.agentApp.client.UserClient;
import com.holiday.agentApp.model.Inbox;
import com.holiday.agentApp.model.Message;
import com.holiday.agentApp.model.TUser;
import com.holiday.agentApp.requestAndResponse.InboxByIdResponse;
import com.holiday.agentApp.requestAndResponse.MessageByInboxResponse;
import com.holiday.agentApp.requestAndResponse.MessageSaveResponse;

@Controller
@RequestMapping("/inbox")
public class InboxController {

	
	
	@Autowired
	private MessageClient messageClient;
	
	@Autowired
	private InboxClient inboxClient;
	
	@Autowired
	private UserClient userClient;
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String inboxHome(HttpServletRequest request){
		TUser user=userClient.userById(1L).getValue().getUser();
		System.out.println("Korisnik: "+user.getEmail());
		List<Inbox> inbox=  inboxClient.findByReceiver(user).getValue().getInbox();
		if(inbox!=null){
			request.getSession().setAttribute("inboxes",inbox);
		}else{
			request.getSession().setAttribute("inboxes", new ArrayList<Inbox>());
		}

		
		return "forward:/inbox.jsp";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<List<Message>> findInbox(@PathVariable ("id") Long id){
		
		JAXBElement<InboxByIdResponse> inbox=inboxClient.findById(id);
		System.out.println(inbox.getValue().getInbox().getReceiver().getId());
		System.out.println(	inbox.getValue().getInbox().getMessage().size());
	
		JAXBElement<MessageByInboxResponse> messages= messageClient.findByInbox(inbox.getValue().getInbox());
		
		return new ResponseEntity<List<Message>>(messages.getValue().getMessageSaved(),HttpStatus.OK);
	}

	@RequestMapping(value="/sendMessage/{inboxId}",method=RequestMethod.POST)
	public ResponseEntity<Message> sentMessage(@RequestBody Message message,@PathVariable("inboxId") Long inboxId){
		JAXBElement<InboxByIdResponse> inbox=inboxClient.findById(inboxId);
		
		message.setSentBy(inbox.getValue().getInbox().getReceiver());
		message.setInbox(inbox.getValue().getInbox());
		JAXBElement<MessageSaveResponse> mess=messageClient.saveMessage(message);
		return new ResponseEntity<Message>(mess.getValue().getMessageSaved(),HttpStatus.CREATED);
	}
	
}
