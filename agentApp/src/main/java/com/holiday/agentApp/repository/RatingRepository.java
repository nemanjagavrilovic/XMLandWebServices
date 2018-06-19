package com.holiday.agentApp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.holiday.agentApp.model.Rating;

@Repository
public interface RatingRepository extends PagingAndSortingRepository<Rating,Long>{

}
