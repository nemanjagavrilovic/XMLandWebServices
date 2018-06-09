package com.holiday.agentApp.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.holiday.agentApp.model.Arrangment;

@Repository
public interface ArrangmentsRepository extends PagingAndSortingRepository<Arrangment,Long>{

	@Transactional
	@Modifying
	@Query("update Arrangment a set a.realized=?1 where a.id=?2")
	public int update(boolean realized,Long id);
	
}
