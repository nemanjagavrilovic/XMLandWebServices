package com.holiday.agentApp.service;

import java.util.List;

import com.holiday.agentApp.model.Arrangment;

public interface ArrangmentService {

	public List<Arrangment> findAll();
	public Arrangment findOne(Long id);
	public Arrangment save(Arrangment arrangment);
	public int update(boolean realized,Long id);
}
