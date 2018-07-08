package com.quatspec.service.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quatspec.persistence.domain.User;
import com.quatspec.persistence.repository.UserRepository;
import com.quatspec.service.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	public final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public User findById(Long id) {
		Optional<User> UserOptional = userRepository.findById(id);
		if(UserOptional.isPresent()){
			 return UserOptional.get();
		}
		return null;
	}

	@Override
	public void saveUser(User data) {
		userRepository.save(data);		
	}

	@Override
	public void updateUser(User data) {
		saveUser(data);
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public void deleteAllData() {
		userRepository.deleteAll();	
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public boolean isUserExist(User user) {
		
		return userRepository.existsById(user.getId());
	}

}
