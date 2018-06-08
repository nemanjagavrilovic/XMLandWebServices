package com.holiday.agentApp.service;


import com.holiday.agentApp.model.Services;

public interface ServicesService {

	public Services save(Services service);
	public Services findByOne(Long id);
}
