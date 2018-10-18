package com.quatspec.persistence.repository;

import org.springframework.transaction.annotation.Transactional;

import com.quatspec.api.model.IOrganization;
import com.quatspec.persistence.domain.Organization;
import com.quatspec.persistence.repository.base.OrganizationBaseRepository;

@Transactional
public interface OrganizationRepository extends OrganizationBaseRepository<Organization>{

	Organization findByName(String name);
	IOrganization save(IOrganization iOrganization);
	
}
