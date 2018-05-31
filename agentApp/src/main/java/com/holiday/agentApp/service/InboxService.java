package com.holiday.agentApp.service;

import com.holiday.agentApp.model.Inbox;
import com.holiday.agentApp.model.TUser;

public interface InboxService {

	Inbox findBySenderAndReceiver(TUser senderId,TUser receiverId);

}
