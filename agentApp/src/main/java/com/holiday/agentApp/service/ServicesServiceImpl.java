package com.holiday.agentApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holiday.agentApp.model.Services;
import com.holiday.agentApp.repository.ServicesRepository;

@Service
public class ServicesServiceImpl implements ServicesService{

	@Autowired
	private ServicesRepository servicesRepository;
	@Override
	public Services findByOne(Long id) {
		// TODO Auto-generated method stub
		return servicesRepository.findOne(id);
	}
	@Override
	public Services save(Services service) {
		// TODO Auto-generated method stub
		return servicesRepository.save(service);
	}

}
