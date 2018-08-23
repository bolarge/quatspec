package com.quatspec.api.service;


import java.util.List;

import com.quatspec.api.exception.QuaspecServiceException;
import com.quatspec.api.model.IBankAccount;

public interface IBankAccountService {

    List<? extends IBankAccount> getByIUser(String username) throws QuaspecServiceException;

    IBankAccount createBankAccount(IBankAccount account) throws QuaspecServiceException;
    
    IBankAccount createSavingsAccount(IBankAccount account) throws QuaspecServiceException;
    
    IBankAccount createFixedDepositAccount(IBankAccount account) throws QuaspecServiceException;
}
