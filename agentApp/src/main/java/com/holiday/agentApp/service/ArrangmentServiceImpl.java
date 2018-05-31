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

}
