package com.quaspec.persistence.repository;

import javax.transaction.Transactional;

import com.quaspec.api.model.IUser;
import com.quaspec.persistence.domain.User;

@Transactional
public interface UserRepository extends UserBaseRepository<User> {

	void save(IUser iUser);
	//T save(IUser iUser);
}
