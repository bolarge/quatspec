package com.quaspec.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.quaspec.persistence.domain.Organization;

public interface OrganizationRepository extends CrudRepository<Organization, Long>{

}
