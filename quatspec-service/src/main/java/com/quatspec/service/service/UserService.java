package com.quatspec.service.service;

import java.util.List;

import com.quatspec.persistence.domain.User;

public interface UserService {
	
	User findById(Long id);
	void saveUser(User data);
	void updateUser(User data);
	void deleteUserById(Long id);
	void deleteAllData();
	List<User> findAll();
	boolean isUserExist(User institution);

}
