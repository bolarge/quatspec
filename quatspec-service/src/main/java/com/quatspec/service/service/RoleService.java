package com.quaspec.service.service;

import java.util.List;

import com.quaspec.persistence.domain.Role;

public interface RoleService {
	
	Role findById(Long id);
	void saveRole(Role data);
	void updateRole(Role data);
	void deleteRoleById(Long id);
	void deleteAllData();
	List<Role> findAll();
	boolean isInstitutionExist(Role role);
}
