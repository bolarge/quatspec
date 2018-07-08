package com.quatspec.persistence.repository;

import javax.transaction.Transactional;

import com.quatspec.api.model.IUser;
import com.quatspec.persistence.domain.User;

@Transactional
public interface UserRepository extends UserBaseRepository<User> {

	void save(IUser iUser);

}
