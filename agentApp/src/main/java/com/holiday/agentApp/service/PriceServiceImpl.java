package com.holiday.agentApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holiday.agentApp.model.Price;
import com.holiday.agentApp.repository.PriceRepository;

@Service
public class PriceServiceImpl implements PriceService{

	@Autowired
	private PriceRepository priceRepository;
	@Override
	public Price save(Price price) {
		// TODO Auto-generated method stub
		return priceRepository.save(price);
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		 priceRepository.delete(id);
	}

}
