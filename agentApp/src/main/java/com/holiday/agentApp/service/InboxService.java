package com.holiday.agentApp.service;

import java.util.List;

import com.holiday.agentApp.model.Inbox;
import com.holiday.agentApp.model.TUser;

public interface InboxService {

	Inbox findBySenderAndReceiver(TUser senderId,TUser receiverId);
	List<Inbox> findByReceiver(TUser receiver);
	Inbox findById(Long id);
}
