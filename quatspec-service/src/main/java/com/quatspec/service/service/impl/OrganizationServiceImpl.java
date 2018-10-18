package com.quatspec.service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quatspec.api.exception.QuaspecServiceException;
import com.quatspec.api.model.IOrganization;
import com.quatspec.api.service.IOrganizationService;
import com.quatspec.persistence.domain.Organization;
import com.quatspec.persistence.repository.DataAccessService;
@Service("organizationService")
public class OrganizationServiceImpl implements IOrganizationService{
	
	@Autowired
	DataAccessService dataAccessService;

	@Override
	public List<? extends IOrganization> getAll() throws QuaspecServiceException {
		return dataAccessService.getOrganizationRepository().findAll();
	}

	@Override
	public List<? extends IOrganization> getByIInstitution(String username) throws QuaspecServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IOrganization get(String name) throws QuaspecServiceException {
		return dataAccessService.getOrganizationRepository().findByName(name);
	}

	@Override
	public IOrganization createOrganization(IOrganization iOrganization) throws QuaspecServiceException {
		Organization organization = null;		
		if(iOrganization != null) {
			organization = new Organization(iOrganization.getName(), iOrganization.getEmail(), iOrganization.getPhoneNumber());
			organization = dataAccessService.getOrganizationRepository().save(organization);
		}
		return organization;
	}
}
