package com.quatspec.persistence.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.quatspec.api.model.IBankAccount;
import com.quatspec.persistence.domain.User;
import com.quatspec.persistence.domain.financialaccount.BankAccount;
import com.quatspec.persistence.repository.base.BankAccountBaseRepository;

@Transactional
public interface BankAccountRepository extends BankAccountBaseRepository<BankAccount> {
	
	IBankAccount save(IBankAccount bankAccount);
	
	//Long saveAndReturnId(IBankAccount bankAccount);

	List<? extends IBankAccount> findByUser(User user);
	
	//List<? extends IBankAccount> findByActive();

	//IBankAccount findById(String id);

}


