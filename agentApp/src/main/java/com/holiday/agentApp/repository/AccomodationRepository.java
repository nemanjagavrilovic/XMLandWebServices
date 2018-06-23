package com.holiday.agentApp.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.holiday.agentApp.model.Accomodation;
import com.holiday.agentApp.model.Location;
import com.holiday.agentApp.model.ObjectCategory;
import com.holiday.agentApp.model.ObjectType;
import com.holiday.agentApp.model.PriceShedule;
import com.holiday.agentApp.model.TUser;

@Repository
public interface AccomodationRepository extends PagingAndSortingRepository<Accomodation,Long>{

	@Modifying
	@Transactional
	@Query("Update Accomodation a set a.priceShedule=?1 where a.id=?2")
	public void update(PriceShedule priceShedule,Long id);
	
	Accomodation findByMaxPersonAndNameAndDescription(
			 int maxPerson,String name
			 ,String description);
	
}

