package com.holiday.agentApp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.holiday.agentApp.model.ObjectType;
@Repository
public interface ObjectTypeRepository extends PagingAndSortingRepository<ObjectType,Long>{

	
}
