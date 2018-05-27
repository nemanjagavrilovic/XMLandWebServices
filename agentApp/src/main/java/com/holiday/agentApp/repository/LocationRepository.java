package com.holiday.agentApp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.holiday.agentApp.model.Location;

@Repository
public interface LocationRepository extends PagingAndSortingRepository<Location,Long> {

	
}
