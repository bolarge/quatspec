package com.quaspec.service.service;

import java.util.List;

import com.quaspec.persistence.domain.Profile;

public interface ProfileService {
	
	Profile findById(Long id);
	void saveProfile(Profile data);
	void updateProfile(Profile data);
	void deleteProfileById(Long id);
	void deleteAllData();
	//List<Profile> findAll();
	boolean isProfileExist(Profile profile);

}
