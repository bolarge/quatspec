package com.quatspec.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quatspec.api.exception.QuaspecServiceException;
import com.quatspec.api.model.IBankAccount;
import com.quatspec.api.model.IUser;
import com.quatspec.api.service.IBankAccountService;
import com.quatspec.api.service.IUserService;
import com.quatspec.persistence.domain.BankAccount;
import com.quatspec.rest.model.BankAccountResource;
import com.quatspec.rest.model.UserResource;
import com.quatspec.service.service.UserService;


@RestController
@RequestMapping(value = "/rest/users", produces = {APPLICATION_JSON_VALUE})
public class UserApi {
	
	//INCLUDE MINIMAL LOGGING TO TRACE APPLICATION EXECUTION 

    @Autowired
    @Qualifier("userService")
    private IUserService appUserService;
    
    @Autowired
    @Qualifier("bankAccountService")
    private IBankAccountService bankAccountService;

    /*@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new AdvisorValidator());
    }*/

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(method = RequestMethod.GET)
    public List<UserResource> search() throws QuaspecServiceException {

        List<UserResource> result = new ArrayList<>();
        List<? extends IUser> userEntities = appUserService.getAll();
        for (IUser userEntity : userEntities) {
            result.add(new UserResource(userEntity));
        }
        return result;
    }
    
    //rest/users/[userName]/accounts
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value="/{userName}/accounts", method = RequestMethod.GET)
    public List<BankAccountResource> getUserBankAccounts(@PathVariable("userName") String userName) throws QuaspecServiceException{
		
    	List<BankAccountResource> accounts = new ArrayList<>();
    	
    	List<? extends IBankAccount> accountEntities = bankAccountService.getByIUser(userName);
    	for (IBankAccount accountEntity : accountEntities) {
    			accounts.add(new BankAccountResource(accountEntity));
    	}
    	return accounts; 	
    }

}
