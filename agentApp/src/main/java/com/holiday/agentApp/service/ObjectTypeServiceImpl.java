package com.holiday.agentApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holiday.agentApp.model.ObjectType;
import com.holiday.agentApp.repository.ObjectTypeRepository;
@Service
public class ObjectTypeServiceImpl implements ObjectTypeService{

	@Autowired
	private ObjectTypeRepository objectTypeRepository;
	
	@Override
	public ObjectType getObjectType(Long id) {
		// TODO Auto-generated method stub
		return objectTypeRepository.findOne(id);
	}

	@Override
	public ObjectType save(ObjectType type) {
		// TODO Auto-generated method stub
		return objectTypeRepository.save(type);
	}

}
