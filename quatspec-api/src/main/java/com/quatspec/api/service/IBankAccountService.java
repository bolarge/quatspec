package com.quatspec.api.service;

import java.util.List;

import com.quatspec.api.exception.QuaspecServiceException;
import com.quatspec.api.model.IBankAccount;

public interface IBankAccountService {

    List<? extends IBankAccount> getByIUser(String username) throws QuaspecServiceException;

    IBankAccount createAccount(IBankAccount account) throws QuaspecServiceException;
    
    void withdrawFromAccount(String accountNumber, double withdrawAmount) throws QuaspecServiceException;
    
    void transferFromAccount(String fromAccountNumber, String toAccountNumber, double transferAmount);
    
    //void createBankAccount(IBankAccount account);
    
    Long createAndReturnAccountId(IBankAccount bankAccountDetails);
	
	List<? extends IBankAccount> getInactiveBankAccounts();
	
	IBankAccount deActivateBankAccount(String accountNumber);

	void deActivateBankAccount(List<IBankAccount> account);
	
}
