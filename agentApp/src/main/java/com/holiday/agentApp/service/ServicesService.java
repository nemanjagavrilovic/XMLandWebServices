package com.holiday.agentApp.service;


import java.util.List;

import com.holiday.agentApp.model.Services;

public interface ServicesService {

	public Services save(Services service);
	public Services findByOne(Long id);
	public Services find(String name);
	public List<Services> findAll();
	public void delete(Long id);

}
