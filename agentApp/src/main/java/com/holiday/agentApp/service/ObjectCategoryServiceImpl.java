package com.holiday.agentApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holiday.agentApp.model.ObjectCategory;
import com.holiday.agentApp.repository.ObjectCategoryRepository;

@Service
public class ObjectCategoryServiceImpl implements ObjectCategoryService {

	@Autowired
	private ObjectCategoryRepository objectCategoryRepository;
	@Override
	public ObjectCategory findById(Long id) {
		// TODO Auto-generated method stub
		return objectCategoryRepository.findOne(id);
	}
	@Override
	public ObjectCategory save(ObjectCategory category) {
		// TODO Auto-generated method stub
		return objectCategoryRepository.save(category);
	}

}
