package com.quatspec.persistence.repository;

import javax.transaction.Transactional;

import com.quatspec.api.model.IUser;
import com.quatspec.persistence.domain.User;
import com.quatspec.persistence.repository.base.UserBaseRepository;

@Transactional
public interface UserRepository extends UserBaseRepository<User> {

	IUser save(IUser iUser);
	//T save(IUser iUser);
}
