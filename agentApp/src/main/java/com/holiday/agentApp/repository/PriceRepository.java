package com.holiday.agentApp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.holiday.agentApp.model.Price;

@Repository
public interface PriceRepository extends PagingAndSortingRepository<Price,Long>{

}
