package com.holiday.agentApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holiday.agentApp.model.PriceShedule;
import com.holiday.agentApp.repository.PriceScheduleRepository;

@Service
public class PriceSheduleServiceImpl implements PriceScheduleService{

	@Autowired
	private PriceScheduleRepository priceSheduleRepository;
	@Override
	public PriceShedule save(PriceShedule priceShedule) {
		// TODO Auto-generated method stub
		return priceSheduleRepository.save(priceShedule);
	}

	@Override
	public PriceShedule findById(Long id) {
		// TODO Auto-generated method stub
		return priceSheduleRepository.findOne(id);
	}

}
