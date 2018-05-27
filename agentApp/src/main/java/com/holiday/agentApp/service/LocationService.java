package com.holiday.agentApp.service;

import com.holiday.agentApp.model.Location;

public interface LocationService {

	public Location save(Location location);
	public Location findById(Long id);
}
