package com.quatspec.service.service;

import java.util.List;

import com.quatspec.persistence.domain.Institution;

public interface InstitutionService {
	
	Institution findById(Long id);
	void saveInstitution(Institution data);
	void updateInstitution(Institution data);
	void deleteInstitutionById(Long id);
	void deleteAllData();
	List<Institution> findAll();
	boolean isInstitutionExist(Institution institution);

}
