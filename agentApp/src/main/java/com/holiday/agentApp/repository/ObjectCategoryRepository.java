package com.holiday.agentApp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.holiday.agentApp.model.ObjectCategory;
@Repository
public interface ObjectCategoryRepository extends PagingAndSortingRepository<ObjectCategory,Long>{

	
}
