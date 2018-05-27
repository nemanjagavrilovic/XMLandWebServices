package com.holiday.agentApp.service;

import com.holiday.agentApp.model.ObjectType;

public interface ObjectTypeService {
	ObjectType save(ObjectType type);
	ObjectType getObjectType(Long id);
}
