package com.holiday.agentApp.service;

import java.util.List;

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

	@Override
	public List<ObjectType> findAll() {
		// TODO Auto-generated method stub
		return (List<ObjectType>) objectTypeRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		 objectTypeRepository.delete(id);
	}

}
