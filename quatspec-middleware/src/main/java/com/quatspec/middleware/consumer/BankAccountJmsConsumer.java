package com.quatspec.middleware;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.quatspec.api.exception.QuaspecError;
import com.quatspec.api.exception.QuaspecServiceException;
import com.quatspec.api.model.IBankAccount;
import com.quatspec.api.service.IBankAccountService;
import com.quatspec.service.service.impl.BankAccountServiceImpl;

@Service("bankAccountJmsConsumer")
public class BankAccountJmsConsumer implements IBankAccountService {
	
    public final Logger logger = LoggerFactory.getLogger(BankAccountJmsConsumer.class);
    
    @Autowired
    @Qualifier("bankAccountService")
    private IBankAccountService bankAccountService;
    private IBankAccount lastReceived;
    
    public synchronized IBankAccount getLastReceived() {
        return lastReceived;
    }
    
    public synchronized void setLastReceived(IBankAccount account) {
        this.lastReceived = account;
    }

	@Override
	public List<? extends IBankAccount> getByIUser(String username) throws QuaspecServiceException {
		throw new QuaspecServiceException(new QuaspecError("No asynchronous service to get bank account by user."));
	}

	@Override
	@JmsListener(containerFactory = "defaultJmsListenerContainerFactory", destination = Constants.QUEUE_BANK_ACCOUNT_CREATE)
	public IBankAccount createAccount(IBankAccount account) throws QuaspecServiceException {
		logger.warn("Received " + account);
        setLastReceived(account);
        return bankAccountService.createAccount(account);
	}

	@Override
	public void withdrawFromAccount(String accountNumber, int withdrawAmount) throws QuaspecServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferFromAccount(String fromAccountNumber, String toAccountNumber, int transferAmount) {
		// TODO Auto-generated method stub
		
	}
}

