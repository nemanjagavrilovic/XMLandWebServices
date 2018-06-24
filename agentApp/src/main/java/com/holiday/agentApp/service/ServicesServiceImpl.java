package com.holiday.agentApp.service;

import java.util.List;

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
	@Override
	public List<Services> findAll() {
		// TODO Auto-generated method stub
		return (List<Services>) servicesRepository.findAll();
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		servicesRepository.delete(id);
	}
	@Override
	public Services find(String name) {
		// TODO Auto-generated method stub
		return servicesRepository.findByService(name);
	}

}
