package com.holiday.agentApp.service;

import java.util.List;

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
		if(!objectCategoryRepository.exists(category.getId())){
			return objectCategoryRepository.save(category);
		}
		return category;
	}
	@Override
	public List<ObjectCategory> findAll() {
		// TODO Auto-generated method stub
		return (List<ObjectCategory>) objectCategoryRepository.findAll();
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		objectCategoryRepository.delete(id);
	}

}
