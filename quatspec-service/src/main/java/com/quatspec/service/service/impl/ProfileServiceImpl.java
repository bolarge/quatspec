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
import com.quatspec.persistence.repository.ProfileRepository;
import com.quatspec.service.service.ProfileService;

@Service("userProfileService")
public class ProfileServiceImpl implements ProfileService, IProfileService {
	
	final Logger logger = LoggerFactory.getLogger(ProfileServiceImpl.class);
	
	@Autowired
	private ProfileRepository profileRepository;

	@Override
	@Transactional
	public void saveProfile(Profile userProfile) {
		profileRepository.save(userProfile);		
	}

	@Override
	@Transactional
	public void updateProfile(Profile userProfile) {	
		saveProfile(userProfile);
	}

	/*@Override
	public List<Profile> findAll() {		
		return (List<Profile>) profileRepository.findAll();
	}*/

	@Override
	public Profile findById(Long Id) {
		Optional<Profile> userProfileOptional = profileRepository.findById(Id);
		if(userProfileOptional.isPresent()){
			return userProfileOptional.get();
		}
		return null;
	}

	@Override
	@Transactional
	public void deleteProfileById(Long id) {
		// TODO Auto-generated method stub	
	}

	@Override
	@Transactional
	public void deleteAllData() {
		// TODO Auto-generated method stub	
	}

	@Override
	public boolean isProfileExist(Profile profile) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<? extends IProfile> getByIUser(IUser iUser) throws QuaspecServiceException {		
		return (List<? extends IProfile>) profileRepository.findProfileByUserId(iUser.getId());
	}

}
