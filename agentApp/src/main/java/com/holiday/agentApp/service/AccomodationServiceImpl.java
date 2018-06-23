package com.holiday.agentApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holiday.agentApp.model.Accomodation;
import com.holiday.agentApp.model.PriceShedule;
import com.holiday.agentApp.repository.AccomodationRepository;

@Service
public class AccomodationServiceImpl implements AccomodationService{

	@Autowired
	private AccomodationRepository accomodationRepository;
	@Override
	public Accomodation save(Accomodation accomodation) {
		// TODO Auto-generated method stub
		return accomodationRepository.save(accomodation);
	}
	@Override
	public Accomodation findById(Long id) {
		// TODO Auto-generated method stub
		return accomodationRepository.findOne(id);
	}
	@Override
	public void update(PriceShedule priceShedule,Long id) {
		// TODO Auto-generated method stub
		 accomodationRepository.update(priceShedule,id);
	}
	@Override
	public List<Accomodation> findAll() {
		// TODO Auto-generated method stub
		return  (List<Accomodation>) accomodationRepository.findAll();
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		 accomodationRepository.delete(id);
	}
	@Override
	public Accomodation find(Accomodation accomodation) {
		// TODO Auto-generated method stub
		return accomodationRepository.findByMaxPersonAndNameAndDescription(accomodation.getMaxPerson(),
				 accomodation.getName(), accomodation.getDescription());
	}

	
}
