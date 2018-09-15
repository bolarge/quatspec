package com.quaspec.controller.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quaspec.api.exception.QuaspecServiceException;
import com.quaspec.api.model.IBankAccount;
import com.quaspec.api.service.IBankAccountService;
import com.quaspec.controller.rest.model.BankAccountResource;
import com.quaspec.persistence.domain.BankAccount;

@RestController
@RequestMapping(value = "/rest/accounts", produces = {APPLICATION_JSON_VALUE}, consumes = {APPLICATION_JSON_VALUE})
public class BankAccountApi {

    @Autowired
    @Qualifier("bankAccountService")
    private IBankAccountService bankAccountService;


    @Secured({"ROLE_USER"})
    @RequestMapping(value="/getaccounts", method = RequestMethod.GET)
    public List<BankAccountResource> getAll() throws QuaspecServiceException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        List<BankAccountResource> result = new ArrayList<>();

        List<? extends IBankAccount> bankAccountEntities = bankAccountService.getByIUser(name);
        for (IBankAccount bankAccountEntity : bankAccountEntities) {
            result.add(new BankAccountResource(bankAccountEntity));
        }
        return result;
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value="/openaccount", method = RequestMethod.POST)
    public BankAccountResource openAccount(@RequestBody BankAccountResource account) throws QuaspecServiceException {
    	IBankAccount bankAccount = null;
    	String accountType = account.getAccountType();
    	if(accountType.equalsIgnoreCase("S")) {
	        bankAccount = (IBankAccount) bankAccountService.createAccount(account);
	        if (bankAccount != null) {
	            return new BankAccountResource(bankAccount);
	        }
    	}else if(accountType.equalsIgnoreCase("F")){
    		bankAccount = (IBankAccount) bankAccountService.createAccount(account);
	        if (bankAccount != null) {
	            return new BankAccountResource(bankAccount);
	        }
    	}
        return null;
    }
}
