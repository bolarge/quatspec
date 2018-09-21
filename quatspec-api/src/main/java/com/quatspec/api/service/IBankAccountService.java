package com.quatspec.api.service;


import java.util.List;

import com.quatspec.api.exception.QuaspecServiceException;
import com.quatspec.api.model.IBankAccount;

public interface IBankAccountService {

    List<? extends IBankAccount> getByIUser(String username) throws QuaspecServiceException;

    IBankAccount createAccount(IBankAccount account) throws QuaspecServiceException;
    
    //IBankAccount createSavingsAccount(IBankAccount account) throws QuaspecServiceException;
    
    //IBankAccount createFixedDepositAccount(IBankAccount account) throws QuaspecServiceException;
    
    void withdrawFromAccount(String accountNumber, int withdrawAmount) throws QuaspecServiceException;
    
    void transferFromAccount(String fromAccountNumber, String toAccountNumber, int transferAmount);
}
