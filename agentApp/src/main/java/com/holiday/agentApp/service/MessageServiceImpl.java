package com.holiday.agentApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holiday.agentApp.model.Inbox;
import com.holiday.agentApp.model.Message;
import com.holiday.agentApp.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	private MessageRepository messageRepository;
	@Override
	public List<Message> findByInbox(Inbox inbox) {
		// TODO Auto-generated method stub
		return messageRepository.findByInbox(inbox);
	}

}
