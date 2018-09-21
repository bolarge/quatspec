package com.quatspec.persistence.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.quatspec.api.model.IBankAccount;
import com.quatspec.persistence.domain.BankAccount;
import com.quatspec.persistence.domain.Customer;
import com.quatspec.persistence.domain.User;
import com.quatspec.persistence.repository.base.BankAccountBaseRepository;

@Transactional
public interface BankAccountRepository extends BankAccountBaseRepository<BankAccount> {

	BankAccount save(IBankAccount bankAccount);

	List<? extends IBankAccount> findByUser(Customer user);

	List<? extends IBankAccount> findByUser(User user);
}


