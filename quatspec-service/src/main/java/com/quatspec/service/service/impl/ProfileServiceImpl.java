package com.quatspec.service.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quatspec.api.exception.QuaspecServiceException;
import com.quatspec.api.model.IProfile;
import com.quatspec.api.model.IUser;
import com.quatspec.api.service.IProfileService;
import com.quatspec.persistence.domain.Profile;
import com.quatspec.persistence.repository.DataAccessService;
import com.quatspec.persistence.repository.ProfileRepository;

@Service("userProfileService")
public class ProfileServiceImpl implements IProfileService {
	
	final Logger logger = LoggerFactory.getLogger(ProfileServiceImpl.class);
	
	@Autowired
	DataAccessService dataAccessService;

	@Override
	public List<? extends IProfile> getByIUser(IUser iUser) throws QuaspecServiceException {		
		return (List<? extends IProfile>) (IProfile)dataAccessService.getProfileRepository().findProfileByUserId(iUser.getUserId());
	}

}
