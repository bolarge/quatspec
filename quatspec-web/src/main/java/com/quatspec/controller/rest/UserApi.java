package com.quatspec.controller.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quatspec.api.exception.QuaspecServiceException;
import com.quatspec.api.model.IBankAccount;
import com.quatspec.api.model.IUser;
import com.quatspec.api.service.IBankAccountService;
import com.quatspec.api.service.IUserService;
import com.quatspec.controller.rest.model.IBankAccountResource;
import com.quatspec.controller.rest.model.IUserResource;
import com.quatspec.service.application.service.LoggerService;

@RestController
@RequestMapping(value = "/rest/api/users", produces = {APPLICATION_JSON_VALUE})
public class UserApi {

    @Autowired
    @Qualifier("userService")
    private IUserService appUserService;
    
    @Autowired
    @Qualifier("bankAccountService")
    private IBankAccountService bankAccountService;

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(method = RequestMethod.GET)
    public List<IUserResource> search() throws QuaspecServiceException {
        List<IUserResource> result = new ArrayList<>();
        List<? extends IUser> userEntities = appUserService.getAll();
        for (IUser userEntity : userEntities) {
            result.add(new IUserResource(userEntity));
        }
        return result;
    }
    
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value="/{userName}/accounts", method = RequestMethod.GET)
    public List<IBankAccountResource> getUserBankAccounts(@PathVariable("userName") String userName) throws QuaspecServiceException{
    	List<IBankAccountResource> accounts = new ArrayList<>();
    	List<? extends IBankAccount> accountEntities = bankAccountService.getByIUser(userName);
    	for (IBankAccount accountEntity : accountEntities) {
    			accounts.add(new IBankAccountResource(accountEntity));
    	}
    	return accounts; 	
    }
    
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping(method = RequestMethod.POST)
    public IUserResource create(@RequestBody IUserResource user) throws QuaspecServiceException {
        IUser saved = appUserService.createUser(user);
        if (saved != null) {      	
            return new IUserResource(user);
        }
        return null;
    }

}
