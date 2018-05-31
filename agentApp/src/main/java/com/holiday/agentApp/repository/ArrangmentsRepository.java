package com.holiday.agentApp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.holiday.agentApp.model.Arrangment;

@Repository
public interface ArrangmentsRepository extends PagingAndSortingRepository<Arrangment,Long>{

	
}
