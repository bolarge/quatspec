package com.quatspec.api.service;

import java.util.List;

import com.quatspec.api.exception.QuaspecServiceException;
import com.quatspec.api.model.IProfile;
import com.quatspec.api.model.IUser;

public interface IProfileService {

	List<? extends IProfile> getByIUser(IUser iUser) throws QuaspecServiceException;
}
