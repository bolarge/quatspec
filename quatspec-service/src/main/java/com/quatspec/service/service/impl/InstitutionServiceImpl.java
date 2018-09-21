package com.quaspec.service.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quaspec.persistence.domain.Institution;
import com.quaspec.persistence.repository.InstitutionRepository;
import com.quaspec.service.service.InstitutionService;

@Service("institutionService")
public class InstitutionServiceImpl implements InstitutionService{

	public final Logger logger = LoggerFactory.getLogger(InstitutionServiceImpl.class);
	
	@Autowired
	private InstitutionRepository institutionReposiory;

	@Override
	@Transactional(readOnly = true)
	public Institution findById(Long id) {
		Optional<Institution> institutionOptional = institutionReposiory.findById(id);
		if(institutionOptional.isPresent()){
			 return institutionOptional.get();
		}
		return null;
	}

	@Override
	public void saveInstitution(Institution data) {
		institutionReposiory.save(data);	
	}

	@Override
	public void updateInstitution(Institution data) {
		saveInstitution(data);	
	}

	@Override
	public void deleteInstitutionById(Long id) {
		institutionReposiory.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public void deleteAllData() {
		institutionReposiory.deleteAll();	
	}

	@Override
	@Transactional(readOnly = true)
	public List<Institution> findAll() {
		return (List<Institution>) institutionReposiory.findAll();
	}

	@Override
	public boolean isInstitutionExist(Institution institution) {
		return institutionReposiory.existsById(institution.getId());
	}

}
