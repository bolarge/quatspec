package com.quaspec.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quaspec.api.exception.QuaspecServiceException;
import com.quaspec.api.model.IBankAccount;
import com.quaspec.api.service.IBankAccountService;
import com.quaspec.persistence.domain.BankAccount;
import com.quaspec.persistence.domain.Customer;
import com.quaspec.persistence.domain.FixedDepositAccount;
import com.quaspec.persistence.domain.SavingsAccount;
import com.quaspec.persistence.repository.DataAccessService;

import java.util.ArrayList;
import java.util.List;

@Service("bankAccountService")
public class BankAccountServiceImpl implements IBankAccountService {
	
	@Autowired
	DataAccessService dataAccessService;

    @Override
    @Transactional
    public List<? extends IBankAccount> getByIUser(String username) throws QuaspecServiceException {
    	Customer user = (Customer) dataAccessService.getUserRepository().findByUserName(username);
        if (user != null) {
            return dataAccessService.getBankAccountRepository().findByUser(user);
        }
        return new ArrayList<>();
    }

    @Override
    @Transactional
    public BankAccount createAccount(IBankAccount account) throws QuaspecServiceException {
    	Customer user = (Customer) account.getUser();//Concrete Class of User object
        if (user != null) {
        	Customer userEntity = (Customer) dataAccessService.getUserRepository().findByUserName((account.getUser().getUserName()));

            if (userEntity != null) {
            	if(account.getAccountType().equalsIgnoreCase("S")) {
	                IBankAccount bankAccount = new SavingsAccount(account.getAccountNumber(), userEntity);
	                return dataAccessService.getBankAccountRepository().saveBankAccount(bankAccount);
            	}
            	else if(account.getAccountType().equalsIgnoreCase("F")) {
            		IBankAccount bankAccount = new FixedDepositAccount(account.getAccountNumber(), userEntity);
	                return dataAccessService.getBankAccountRepository().saveBankAccount(bankAccount);
            	}
            }
        }
        return null;
    }

	@Override
	public void withdrawFromAccount(String accountNumber, int withdrawAmount) throws QuaspecServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferFromAccount(String fromAccountNumber, String toAccountNumber, int transferAmount) {
		// TODO Auto-generated method stub
		
	}

}
