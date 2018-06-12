package com.holiday.agentApp.service;

import java.util.List;

import com.holiday.agentApp.model.ObjectType;

public interface ObjectTypeService {
	ObjectType save(ObjectType type);
	ObjectType getObjectType(Long id);
	public List<ObjectType> findAll();
}
