package com.quaspec.service.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quaspec.api.exception.QuaspecServiceException;
import com.quaspec.api.model.IProfile;
import com.quaspec.api.model.IUser;
import com.quaspec.api.service.IProfileService;
import com.quaspec.persistence.domain.Profile;
import com.quaspec.persistence.repository.ProfileRepository;
import com.quaspec.service.service.ProfileService;

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
		return (List<? extends IProfile>) (IProfile)profileRepository.findProfileByUserId(iUser.getId());
	}

}
