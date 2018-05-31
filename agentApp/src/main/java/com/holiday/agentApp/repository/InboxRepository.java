package com.holiday.agentApp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.holiday.agentApp.model.Inbox;
import com.holiday.agentApp.model.TUser;

@Repository
public interface InboxRepository extends PagingAndSortingRepository<Inbox,Long>{

	@Query("SELECT i from Inbox i where i.sender=?1 and i.receiver=?2")
	Inbox findBySenderAndReceiver(TUser senderId,TUser receiverId);
	
}
