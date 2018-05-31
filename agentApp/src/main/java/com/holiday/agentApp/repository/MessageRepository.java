package com.holiday.agentApp.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.holiday.agentApp.model.Inbox;
import com.holiday.agentApp.model.Message;

@Repository
public interface MessageRepository extends PagingAndSortingRepository<Message,Long> {

	List<Message> findByInbox(Inbox inbox);
}
