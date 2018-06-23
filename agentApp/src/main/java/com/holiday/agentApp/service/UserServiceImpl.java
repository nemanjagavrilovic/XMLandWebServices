package com.holiday.agentApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holiday.agentApp.model.TUser;
import com.holiday.agentApp.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public TUser save(TUser user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}
	@Override
	public TUser findById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}
	@Override
	public TUser findByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return userRepository.findByEmailAndPassword(email, password);
	}

}
