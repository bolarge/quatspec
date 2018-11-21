package com.quatspec.service.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quatspec.api.exception.QuaspecServiceException;
import com.quatspec.api.model.IUser;
import com.quatspec.api.service.IUserService;
import com.quatspec.persistence.domain.Employee;
import com.quatspec.persistence.domain.Organization;
import com.quatspec.persistence.domain.User;
import com.quatspec.persistence.repository.DataAccessService;

@Service("userService")
public class UserServiceImpl implements IUserService{

	public final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	DataAccessService dataAccessService;
	
	@Autowired
    @Qualifier("quatspecSecurityPasswordEncoder")
    private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public IUser getByUserId(Long userId) throws QuaspecServiceException {
		Optional<User> user =  dataAccessService.getUserRepository().findById(userId);
		if(user.isPresent()){
			 return user.get();
		}
		return null;	
	}

	@Override
	@Transactional
	public List<? extends IUser> getAll() throws QuaspecServiceException {
		return dataAccessService.getUserRepository().findAll();
	}

	@Override
	@Transactional
	public IUser getByUsername(String username) throws QuaspecServiceException {
		return dataAccessService.getUserRepository().findByUserName(username);
	}

	@Override
	public IUser createUser(IUser iUser) throws QuaspecServiceException {
		IUser user = null;
		User customer = null;
		Employee employee = null;
		Organization organization = dataAccessService.getOrganizationRepository().findByName(iUser.getOrganization().getName());
		if(iUser.getUserType().equalsIgnoreCase("1")) { 
			customer = new User(iUser.getUserName(),iUser.getEmail(),passwordEncoder.encode(iUser.getPassword()),iUser.getGsmPhoneNumber(), iUser.getNationalId(), organization);
			user = dataAccessService.getUserRepository().save(customer);
		} else if (iUser.getUserType().equalsIgnoreCase("2")) {
			employee = new Employee(iUser.getUserName(),iUser.getEmail(),passwordEncoder.encode(iUser.getPassword()),iUser.getGsmPhoneNumber(), iUser.getNationalId(), organization);
			user = dataAccessService.getUserRepository().save(employee);
		}		
		return user;			
	}

	@Override
	public IUser updateUser(IUser iUser) throws QuaspecServiceException {
		return createUser(iUser);
	}

	@Override
	public void deleteUser(String userId) throws QuaspecServiceException {
		dataAccessService.getUserRepository().deleteById(dataAccessService.getUserRepository().findByUserName(userId).getId());	
	}

	@Override
	public boolean isUserExist(String userId) {
		return dataAccessService.getUserRepository().existsById(dataAccessService.getUserRepository().findByUserName(userId).getId());
	}

}
