package com.quaspec.persistence.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.quaspec.api.model.IBankAccount;
import com.quaspec.persistence.domain.BankAccount;
import com.quaspec.persistence.domain.Customer;
import com.quaspec.persistence.domain.User;

@Transactional
public interface BankAccountRepository extends BankAccountBaseRepository<BankAccount> {

	BankAccount saveBankAccount(IBankAccount bankAccount);

	List<? extends IBankAccount> findByUser(Customer user);

	List<? extends IBankAccount> findByUser(User user);
}


