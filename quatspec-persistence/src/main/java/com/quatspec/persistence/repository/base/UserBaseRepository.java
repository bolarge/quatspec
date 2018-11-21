package com.quatspec.persistence.repository.base;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.quatspec.api.model.IUser;
import com.quatspec.persistence.domain.User;

@NoRepositoryBean
public interface UserBaseRepository<T extends User> extends JpaRepository<T, Long> {
	
	T findByUserName (String username);
	
	T findByEmail(String email);
	
	Optional<T> findById (Long userId);
	
}
