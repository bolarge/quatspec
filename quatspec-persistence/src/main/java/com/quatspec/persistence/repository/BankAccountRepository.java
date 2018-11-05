package com.quatspec.persistence.repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

import com.quatspec.api.model.IBankAccount;
import com.quatspec.persistence.domain.User;
import com.quatspec.persistence.domain.financialaccount.BankAccount;
import com.quatspec.persistence.domain.financialaccount.FixedDepositAccount;
import com.quatspec.persistence.repository.base.BankAccountBaseRepository;

@Transactional
public interface BankAccountRepository extends BankAccountBaseRepository<BankAccount> {

	List<? extends IBankAccount> findByUser(User user);
	
	List<? extends IBankAccount> findByActive();
	
	void setAccountsAsActive(List<? extends IBankAccount> acc);
	
	List<? extends IBankAccount> findFixedDepositsByBankAccount(Long bankAccountId);

	IBankAccount findById(String id);
	
	FixedDepositAccount findByAccountNumber(String id);

	long count();

	List<FixedDepositAccount> findTop2ByTenure(int tenure);

	Stream<FixedDepositAccount> findAllByTenure(int tenure);

	@Async
	CompletableFuture<List<FixedDepositAccount>> findAllByFdAmount(int fdAmount);

	@Query("select fd from FixedDepositAccount fd where fd.tenure = ?1 and fd.fdAmount <= ?2 and fd.active = ?3")
	List<FixedDepositAccount> findByCustomQuery(int tenure, int fdAmount, String active);
}


