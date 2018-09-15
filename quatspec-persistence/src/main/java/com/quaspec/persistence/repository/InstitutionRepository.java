package com.quaspec.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.quaspec.persistence.domain.Institution;

@Transactional
public interface InstitutionRepository extends CrudRepository<Institution, Long>{

}
