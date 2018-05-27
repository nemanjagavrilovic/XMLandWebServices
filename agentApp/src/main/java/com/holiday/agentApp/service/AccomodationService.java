package com.holiday.agentApp.service;

import java.util.List;

import com.holiday.agentApp.model.Accomodation;
import com.holiday.agentApp.model.PriceShedule;

public interface AccomodationService {

	public Accomodation save(Accomodation accomodation);
	public Accomodation findById(Long id);
	public void update(PriceShedule priceShedule,Long id);
	public List<Accomodation> findAll();
}
