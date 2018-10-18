package com.quatspec.api.service;

import java.util.List;

import com.quatspec.api.exception.QuaspecServiceException;
import com.quatspec.api.model.IUser;

public interface IUserService {
	
	IUser getByUserId(Long userId) throws QuaspecServiceException;
	
	List<? extends IUser> getAll() throws QuaspecServiceException;
	
	IUser getByUsername(String username) throws QuaspecServiceException;
	
	IUser createUser(IUser iUser) throws QuaspecServiceException;
	
	IUser updateUser(IUser iUser) throws QuaspecServiceException;
	
	void deleteUser(String userId) throws QuaspecServiceException;
	
	boolean isUserExist(String userId);

}
