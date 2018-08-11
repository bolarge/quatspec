package com.quatspec.api.service;


import java.util.List;

import com.quatspec.api.exception.QuaspecServiceException;
import com.quatspec.api.model.IBankAccount;

public interface IBankAccountService {

    List<? extends IBankAccount> getByIUser(String username) throws QuaspecServiceException;

    IBankAccount create(IBankAccount account) throws QuaspecServiceException;
}
