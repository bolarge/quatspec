package com.quatspec.persistence.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.quatspec.api.model.IBankAccount;
import com.quatspec.persistence.domain.financialaccount.BankAccount;

@NoRepositoryBean
public interface BankAccountBaseRepository<T extends BankAccount> extends JpaRepository<T, Long> {
	
	T findByAccountNumber(String accountNumber);
	
	IBankAccount getByAccountNumber (String accountNumber);
}
