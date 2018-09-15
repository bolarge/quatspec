package com.quaspec.api.service;

import java.util.List;

import com.quaspec.api.exception.QuaspecServiceException;
import com.quaspec.api.model.IUser;

public interface IUserService {
	
	List<? extends IUser> getAll() throws QuaspecServiceException;
	IUser get(String username) throws QuaspecServiceException;

}
