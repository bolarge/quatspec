package com.quatspec.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.quatspec.persistence.domain.Institution;

@Transactional
public interface InstitutionRepository extends CrudRepository<Institution, Long>{

}
