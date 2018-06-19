package com.holiday.agentApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holiday.agentApp.model.Arrangment;
import com.holiday.agentApp.repository.ArrangmentsRepository;

@Service
public class ArrangmentServiceImpl implements ArrangmentService{

	@Autowired
	private ArrangmentsRepository arrangmentRepository;
	@Override
	public List<Arrangment> findAll() {
		// TODO Auto-generated method stub
		return (List<Arrangment>) arrangmentRepository.findAll();
	}
	@Override
	public Arrangment findOne(Long id) {
		// TODO Auto-generated method stub
		return arrangmentRepository.findOne(id);
	}
	@Override
	public Arrangment save(Arrangment arrangment) {
		// TODO Auto-generated method stub
		return arrangmentRepository.save(arrangment);
	}
	@Override
	public int update(boolean realized, Long id) {
		// TODO Auto-generated method stub
		return arrangmentRepository.update(realized, id);
	}
	@Override
	public void deleteAll(){
		arrangmentRepository.deleteAll();
	}
}
