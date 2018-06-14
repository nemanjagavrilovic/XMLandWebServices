package com.holiday.agentApp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.holiday.agentApp.model.PriceShedule;

@Repository
public interface PriceScheduleRepository extends PagingAndSortingRepository<PriceShedule,Long> {

}
