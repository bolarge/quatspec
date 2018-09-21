package com.quatspec.api.service;

import java.util.List;

import com.quatspec.api.exception.QuaspecServiceException;
import com.quatspec.api.model.IUser;

public interface IUserService {
	
	List<? extends IUser> getAll() throws QuaspecServiceException;
	
	IUser get(String username) throws QuaspecServiceException;

}
