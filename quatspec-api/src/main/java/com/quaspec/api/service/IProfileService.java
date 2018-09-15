package com.quaspec.api.service;

import java.util.List;

import com.quaspec.api.exception.QuaspecServiceException;
import com.quaspec.api.model.IProfile;
import com.quaspec.api.model.IUser;

public interface IProfileService {

	List<? extends IProfile> getByIUser(IUser iUser) throws QuaspecServiceException;
}
