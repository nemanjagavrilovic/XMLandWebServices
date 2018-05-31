package com.holiday.agentApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holiday.agentApp.model.Inbox;
import com.holiday.agentApp.model.TUser;
import com.holiday.agentApp.repository.InboxRepository;

@Service
public class InboxServiceImpl implements InboxService{

	@Autowired
	private InboxRepository inboxRepository;
	@Override
	public Inbox findBySenderAndReceiver(TUser senderId, TUser receiverId) {
		// TODO Auto-generated method stub
		return inboxRepository.findBySenderAndReceiver(senderId, receiverId);
	}

}
