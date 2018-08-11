package com.quatspec.rest;

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
import com.quatspec.persistence.domain.BankAccount;
import com.quatspec.rest.model.BankAccountResource;

@RestController
@RequestMapping(value = "/rest/accounts", produces = {APPLICATION_JSON_VALUE}, consumes = {APPLICATION_JSON_VALUE})
public class BankAccountApi {

    @Autowired
    @Qualifier("bankAccountService")
    private IBankAccountService bankAccountService;


    @Secured({"ROLE_USER"})
    @RequestMapping(method = RequestMethod.GET)
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
    @RequestMapping(method = RequestMethod.POST)
    public BankAccountResource create(@RequestBody BankAccountResource account) throws QuaspecServiceException {
        BankAccount saved = (BankAccount) bankAccountService.create(account);
        if (saved != null) {
            return new BankAccountResource(saved);
        }
        return null;
    }
}
