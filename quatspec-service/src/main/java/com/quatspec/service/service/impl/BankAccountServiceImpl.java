package com.quatspec.service.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quatspec.api.exception.QuaspecServiceException;
import com.quatspec.api.model.IBankAccount;
import com.quatspec.api.model.IUser;
import com.quatspec.api.service.IBankAccountService;
import com.quatspec.persistence.domain.User;
import com.quatspec.persistence.domain.financialaccount.BankAccount;
import com.quatspec.persistence.repository.DataAccessService;

import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

@Service("bankAccountService")
public class BankAccountServiceImpl implements IBankAccountService {
	
	private static Logger logger = LogManager.getLogger(BankAccountServiceImpl.class);
	
	/*@Autowired
	private JmsTemplate jmsTemplate;*/
	
	@Autowired
	DataAccessService dataAccessService;

    @Override
    @Transactional
    public List<? extends IBankAccount> getByIUser(String username) throws QuaspecServiceException {
    	User user = (User) dataAccessService.getUserRepository().findByUserName(username);
        if (user != null) {
            return dataAccessService.getBankAccountRepository().findByUser(user);
        }
        return new ArrayList<>();
    }

    @Override
    @Transactional
    public IBankAccount createAccount(IBankAccount account) throws QuaspecServiceException {   	     
    	IUser user = account.getUser();
    	if (user != null) {
    		User userEntity = (User) dataAccessService.getUserRepository().findByUserName((account.getUser().getUserName()));
    		if(userEntity != null) { 
    			if(account.getAccountType().equalsIgnoreCase("SA")) {
    				BankAccount bankAccount = new BankAccount(account.getAccountNumber(), account.getBankVerificationNumber(), userEntity);
    				return dataAccessService.getBankAccountRepository().save(bankAccount);    				
    			}
    			else if(account.getAccountType().equalsIgnoreCase("FD")) {
    				BankAccount bankAccount = new BankAccount(account.getAccountNumber(), account.getBankVerificationNumber(), userEntity);
    				return dataAccessService.getBankAccountRepository().save(bankAccount);
    			}
    		}
    	}
    	return null;
    }

	@Override
	public void withdrawFromAccount(String accountNumber, double withdrawAmount) throws QuaspecServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferFromAccount(String fromAccountNumber, String toAccountNumber, double transferAmount) {
		// TODO Auto-generated method stub
		
	}



	/*@Override
	@Transactional(transactionManager = "jmsTxManager")
	@CacheEvict(cacheNames = { "accountList" }, allEntries = true, beforeInvocation = true)
	public void createBankAccount(IBankAccount account) {
		logger.info("createFixedDeposit method invoked");
		jmsTemplate.send("emailQueueDestination", new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage = session.createTextMessage();
				textMessage.setText(account.getUser().getEmail());
				return textMessage;
			}
		});

		// --this JMS message goes to the default destination configured for the
		// JmsTemplate
		jmsTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				ObjectMessage objectMessage = session.createObjectMessage();
				objectMessage.setObject((BankAccount)account);
				return objectMessage;
			}
		});
		
	}*/

	@Override
	public Long createAndReturnAccountId(IBankAccount bankAccountDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends IBankAccount> getInactiveBankAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IBankAccount deActivateBankAccount(String accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deActivateBankAccount(List<IBankAccount> account) {
		// TODO Auto-generated method stub
		
	}

}
