package com.quatspec.persistence.dao;

import com.quatspec.persistence.domain.BankAccount;

public interface BankAccountDao {
	int createBankAccount(BankAccount bankAccountDetails);
	void subtractFromAccount(int bankAccountId, int amount);
}
