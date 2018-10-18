package com.quatspec.controller.rest;

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

import com.quatspec.api.exception.QuaspecServiceException;
import com.quatspec.api.model.IBankAccount;
import com.quatspec.api.service.IBankAccountService;
import com.quatspec.controller.rest.model.IBankAccountResource;

@RestController
@RequestMapping(value = "/rest/api/accounts", produces = {APPLICATION_JSON_VALUE}, consumes = {APPLICATION_JSON_VALUE})
public class BankAccountApi {

    @Autowired
    @Qualifier("bankAccountService")
    private IBankAccountService iBankAccountService;

    @Secured({"ROLE_USER"})
    @RequestMapping(method = RequestMethod.GET)
    public List<IBankAccountResource> getAll() throws QuaspecServiceException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        List<IBankAccountResource> result = new ArrayList<>();

        List<? extends IBankAccount> bankAccountEntities = iBankAccountService.getByIUser(name);
        for (IBankAccount bankAccountEntity : bankAccountEntities) {
            result.add(new IBankAccountResource(bankAccountEntity));
        }
        return result;
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping(method = RequestMethod.POST)
    public IBankAccountResource openAccount(@RequestBody IBankAccountResource account) throws QuaspecServiceException {
    	IBankAccount bankAccount = iBankAccountService.createAccount(account);    	
    	if(bankAccount != null) {	        	        	
	            return new IBankAccountResource(bankAccount);
    	}
        return null;
    }
}
