package com.quatspec.api.service;

import java.util.List;

import com.quatspec.api.exception.QuaspecServiceException;
import com.quatspec.api.model.IOrganization;

public interface IOrganizationService {
	
	List<? extends IOrganization> getAll() throws QuaspecServiceException;
	
	List<? extends IOrganization> getByIInstitution(String username) throws QuaspecServiceException;
	
	IOrganization get(String name) throws QuaspecServiceException;
	
	IOrganization createOrganization(IOrganization iOrganization) throws QuaspecServiceException;
}
