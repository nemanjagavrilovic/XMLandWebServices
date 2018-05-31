package com.holiday.agentApp.service;

import com.holiday.agentApp.model.TUser;

public interface UserService {

	TUser save(TUser user);
	TUser findById(Long id);
}
