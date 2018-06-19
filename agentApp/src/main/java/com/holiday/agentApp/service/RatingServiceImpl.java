package com.holiday.agentApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holiday.agentApp.model.Rating;
import com.holiday.agentApp.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	@Override
	public Rating save(Rating rating) {
		// TODO Auto-generated method stub
		return ratingRepository.save(rating);
	}
	@Override
	public Rating findById(Long id) {
		// TODO Auto-generated method stub
		return ratingRepository.findOne(id);
	}

}
