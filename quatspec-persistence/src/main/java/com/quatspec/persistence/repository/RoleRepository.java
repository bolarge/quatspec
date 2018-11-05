package com.quatspec.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.quatspec.persistence.domain.Role;

@Transactional
public interface RoleRepository extends CrudRepository<Role, Long>{

	@Query("select r from Role as r where LOWER(r.name)=?1")
	Role findByName(String name);

}
