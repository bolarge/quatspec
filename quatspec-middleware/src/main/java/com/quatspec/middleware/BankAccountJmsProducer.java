package com.quatspec.middleware;

import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.quatspec.api.exception.QuaspecError;
import com.quatspec.api.exception.QuaspecServiceException;
import com.quatspec.api.model.IBankAccount;
import com.quatspec.api.service.IBankAccountService;

import javax.jms.Destination;
import java.util.List;

@Service("bankAccountJmsProducer")
public class BankAccountJmsProducer implements IBankAccountService {
	
	public final Logger logger = LoggerFactory.getLogger(BankAccountJmsProducer.class);
	
    @Autowired
    private JmsTemplate template;
    private Destination destination;
    
	@Override
	public List<? extends IBankAccount> getByIUser(String username) throws QuaspecServiceException {
		throw new QuaspecServiceException(new QuaspecError("No asynchronous service to get bank account by user."));
	}
	@Override
	public IBankAccount createAccount(IBankAccount account) throws QuaspecServiceException {
		if (this.destination == null) {
            this.destination = new ActiveMQQueue(Constants.QUEUE_BANK_ACCOUNT_CREATE);
        }
        template.convertAndSend(destination, account);
        return null;
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

