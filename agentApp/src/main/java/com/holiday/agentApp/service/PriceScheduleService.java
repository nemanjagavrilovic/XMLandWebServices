package com.holiday.agentApp.service;

import com.holiday.agentApp.model.PriceShedule;

public interface PriceScheduleService {

	public PriceShedule save(PriceShedule priceShedule);
	public PriceShedule findById(Long id);
}
