package com.quatspec.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.quatspec.persistence.domain.BankAccount;

@NoRepositoryBean
public interface BankAccountBaseRepository<T extends BankAccount> extends JpaRepository<T, Long> {
	
	public T findByAccountNumber (String username);
	
}
