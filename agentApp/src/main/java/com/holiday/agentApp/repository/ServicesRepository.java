package com.holiday.agentApp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.holiday.agentApp.model.Services;

@Repository
public interface ServicesRepository extends PagingAndSortingRepository<Services,Long>{

}
