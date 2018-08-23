/*package com.quatspec.middleware;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.quatspec.api.service.IBankAccountService;

import java.util.List;

@Service("bankAccountJmsConsumer")
public class BankAccountJmsConsumer implements IBankAccountService {

    private static final Logger LOG = Logger.getLogger(BankAccountJmsConsumer.class);

    @Autowired
    @Qualifier("bankAccountPersistenceService")
    private BankAccountService bankAccountService;

    private BankAccount lastReceived;

    @Override
    public List<? extends BankAccount> getByAppUser(String appUserName) throws RecrtServiceException {
        throw new RecrtServiceException(new RecrtError("No asynchronous service to get bank account by user."));
    }

    @Override
    @JmsListener(containerFactory = "defaultJmsListenerContainerFactory", destination = Constants.QUEUE_BANK_ACCOUNT_CREATE)
    public BankAccount create(BankAccount account) throws RecrtServiceException {
        LOG.warn("Received " + account);
        setLastReceived(account);
        return bankAccountService.create(account);
    }

    public synchronized BankAccount getLastReceived() {
        return lastReceived;
    }

    public synchronized void setLastReceived(BankAccount lastReceived) {
        this.lastReceived = lastReceived;
    }
}
*/