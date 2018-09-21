package com.quatspec.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.quatspec.persistence.domain.Organization;

public interface OrganizationRepository extends CrudRepository<Organization, Long>{

}
