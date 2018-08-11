package com.quatspec.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quatspec.api.exception.QuaspecServiceException;
import com.quatspec.api.model.IBankAccount;
import com.quatspec.api.service.IBankAccountService;
import com.quatspec.persistence.domain.BankAccount;
import com.quatspec.persistence.domain.Customer;
import com.quatspec.persistence.repository.BankAccountRepository;
import com.quatspec.persistence.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service("bankAccountService")
public class BankAccountServiceImpl implements IBankAccountService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    @Transactional
    public List<? extends IBankAccount> getByIUser(String username) throws QuaspecServiceException {
    	Customer user = (Customer) userRepository.findByUserName(username);
        //IUser user = userRepository.findByUserName(username);
        if (user != null) {
            return bankAccountRepository.findByUser(user);
        }
        return new ArrayList<>();
    }

    @Override
    @Transactional
    public BankAccount create(IBankAccount account) throws QuaspecServiceException {
    	Customer user = (Customer) account.getUser();//Concrete Class of User object
        //User user = account.getUser();
        // TODO throw exception
        if (user != null) {
            //User userEntity = UserRepository.findOne(account.getUser().getUsername());
        	Customer userEntity = (Customer) userRepository.findByUserName((account.getUser().getUserName()));

            if (userEntity != null) {
                BankAccount target = new BankAccount(account.getAccountNumber(), account.getBic(), userEntity);
                return bankAccountRepository.save(target);
            }
        }
        return null;
    }
}
