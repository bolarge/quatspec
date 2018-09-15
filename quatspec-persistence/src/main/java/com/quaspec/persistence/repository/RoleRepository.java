package com.quaspec.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.quaspec.persistence.domain.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{

	@Query("select r from Role as r where LOWER(r.name)=?1")
	Role findByName(String name);

}
