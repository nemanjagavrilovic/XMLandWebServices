package com.holiday.agentApp.service;

import com.holiday.agentApp.model.Price;

public interface PriceService {

	public Price save(Price price);
	public void delete(Long id);
}
