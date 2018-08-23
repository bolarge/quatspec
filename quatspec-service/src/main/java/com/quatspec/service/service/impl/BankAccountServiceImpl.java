package com.quatspec.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quatspec.api.exception.QuaspecServiceException;
import com.quatspec.api.model.IBankAccount;
import com.quatspec.api.service.IBankAccountService;
import com.quatspec.persistence.domain.BankAccount;
import com.quatspec.persistence.domain.Customer;
import com.quatspec.persistence.domain.FixedDepositAccount;
import com.quatspec.persistence.domain.SavingsAccount;
import com.quatspec.persistence.repository.DataAccessService;

import java.util.ArrayList;
import java.util.List;

@Service("bankAccountService")
public class BankAccountServiceImpl implements IBankAccountService {
	
	@Autowired
	DataAccessService dataAccessService;

    @Override
    @Transactional
    public List<? extends IBankAccount> getByIUser(String username) throws QuaspecServiceException {
    	//Customer user = (Customer)
    	//User user = (User) dataAccessService.getUserRepository().findByUserName(username);
    	Customer user = (Customer) dataAccessService.getUserRepository().findByUserName(username);
    	//Customer customer = (Customer)user;
        if (user != null) {
            return dataAccessService.getBankAccountRepository().findByUser(user);
        }
        return new ArrayList<>();
    }

    @Override
    @Transactional
    public BankAccount createBankAccount(IBankAccount account) throws QuaspecServiceException {
    	Customer user = (Customer) account.getUser();//Concrete Class of User object
        if (user != null) {
        	Customer userEntity = (Customer) dataAccessService.getUserRepository().findByUserName((account.getUser().getUserName()));

            if (userEntity != null) {
                IBankAccount bankAccount = new SavingsAccount(account.getAccountNumber(), userEntity);
                return dataAccessService.getBankAccountRepository().saveBankAccount(bankAccount);
            }
        }
        return null;
    }

	@Override
	public IBankAccount createSavingsAccount(IBankAccount account) throws QuaspecServiceException {
		Customer user = (Customer) account.getUser();//Concrete Class of User object
        if (user != null) {
        	Customer userEntity = (Customer) dataAccessService.getUserRepository().findByUserName((account.getUser().getUserName()));

            if (userEntity != null) {
                IBankAccount bankAccount = new SavingsAccount(account.getAccountNumber(), userEntity);
                return dataAccessService.getBankAccountRepository().saveBankAccount(bankAccount);
            }
        }
        return null;
	}

	@Override
	public IBankAccount createFixedDepositAccount(IBankAccount account) throws QuaspecServiceException {
		Customer user = (Customer) account.getUser();//Concrete Class of User object
        if (user != null) {
        	Customer userEntity = (Customer) dataAccessService.getUserRepository().findByUserName((account.getUser().getUserName()));

            if (userEntity != null) {
                IBankAccount bankAccount = new FixedDepositAccount(account.getAccountNumber(), userEntity);
                return dataAccessService.getBankAccountRepository().saveBankAccount(bankAccount);
            }
        }
        return null;
	}
}
