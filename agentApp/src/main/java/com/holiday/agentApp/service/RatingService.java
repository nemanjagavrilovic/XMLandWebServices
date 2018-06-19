package com.holiday.agentApp.service;

import com.holiday.agentApp.model.Rating;

public interface RatingService {

	public Rating save(Rating rating);
	public Rating findById(Long id);
}
