package com.holiday.agentApp.service;

import java.util.List;

import com.holiday.agentApp.model.Inbox;
import com.holiday.agentApp.model.Message;

public interface MessageService {
	List<Message> findByInbox(Inbox inbox);
}
