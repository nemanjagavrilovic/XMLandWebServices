package com.holiday.agentApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holiday.agentApp.model.Location;
import com.holiday.agentApp.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService{

	@Autowired
	private LocationRepository locationRepository;
	
	@Override
	public Location save(Location location) {
		// TODO Auto-generated method stub
		return locationRepository.save(location);
	}

	@Override
	public Location findById(Long id) {
		// TODO Auto-generated method stub
		return locationRepository.findOne(id);
	}

	@Override
	public List<Location> findAll() {
		// TODO Auto-generated method stub
		return (List<Location>) locationRepository.findAll();
	}

}
