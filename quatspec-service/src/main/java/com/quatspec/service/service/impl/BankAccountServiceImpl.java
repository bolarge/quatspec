package com.quatspec.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quatspec.api.exception.QuaspecServiceException;
import com.quatspec.api.model.IBankAccount;
import com.quatspec.api.model.IUser;
import com.quatspec.api.service.IBankAccountService;
import com.quatspec.persistence.domain.BankAccount;
import com.quatspec.persistence.domain.User;
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
    	User user = (User) dataAccessService.getUserRepository().findByUserName(username);
        if (user != null) {
            return dataAccessService.getBankAccountRepository().findByUser(user);
        }
        return new ArrayList<>();
    }

    @Override
    @Transactional
    public IBankAccount createAccount(IBankAccount account) throws QuaspecServiceException {   	     
    	IUser user = account.getUser();
    	if (user != null) {
    		User userEntity = (User) dataAccessService.getUserRepository().findByUserName((account.getUser().getUserName()));
    		if(userEntity != null) { 
    			if(account.getAccountType().equalsIgnoreCase("SA")) {
    				BankAccount bankAccount = new BankAccount(account.getAccountNumber(), account.getBankVerificationNumber(), userEntity);
    				return dataAccessService.getBankAccountRepository().save(bankAccount);    				
    			}
    			else if(account.getAccountType().equalsIgnoreCase("FD")) {
    				BankAccount bankAccount = new BankAccount(account.getAccountNumber(), account.getBankVerificationNumber(), userEntity);
    				return dataAccessService.getBankAccountRepository().save(bankAccount);
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
