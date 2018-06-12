package com.holiday.agentApp.service;

import java.util.List;

import com.holiday.agentApp.model.ObjectCategory;

public interface ObjectCategoryService {
	ObjectCategory save(ObjectCategory category);
	ObjectCategory findById(Long id);
	public List<ObjectCategory> findAll();
}
