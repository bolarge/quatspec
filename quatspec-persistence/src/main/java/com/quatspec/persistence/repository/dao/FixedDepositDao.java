package com.quatspec.persistence.dao;

import java.util.List;

import com.quatspec.persistence.domain.FixedDepositAccount;

public interface FixedDepositDao {
	int createFixedDeposit(FixedDepositAccount fdd);
	FixedDepositAccount getFixedDeposit(long fixedDepositId);
	List<FixedDepositAccount> getInactiveFixedDeposits();
	void setFixedDepositsAsActive(List<FixedDepositAccount> fds);
	List<FixedDepositAccount> findFixedDepositsByBankAccount(long bankAccountId);
}
