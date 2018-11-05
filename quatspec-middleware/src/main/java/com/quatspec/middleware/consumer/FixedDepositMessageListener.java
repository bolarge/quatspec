package com.quatspec.middleware.consumer;
/*package com.quatspec.middleware.producer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.quatspec.persistence.domain.financialaccount.FixedDepositAccount;
import com.quatspec.persistence.repository.dao.BankAccountDao;
import com.quatspec.persistence.repository.dao.FixedDepositDao;

public class FixedDepositMessageListener implements MessageListener {
	
	private static Logger logger = LogManager.getLogger(FixedDepositMessageListener.class);
	
	@Autowired
	@Qualifier(value = "fixedDepositDao")
	private FixedDepositDao myFixedDepositDao;

	@Autowired
	@Qualifier(value = "bankAccountDao")
	private BankAccountDao bankAccountDao; 

	@Transactional(transactionManager="dbTxManager")
	public int createFixedDeposit(FixedDepositAccount fdd) {
		// -- create fixed deposit
		bankAccountDao.subtractFromAccount(fdd.getAccountNumber(), fdd.getFixedAmount());
		return myFixedDepositDao.createFixedDeposit(fdd);
	}

	@Override
	public void onMessage(Message message) {
		logger.info("FixedDepositMessageListener's onMessage() invoked");
		ObjectMessage objectMessage = (ObjectMessage) message;
		FixedDepositAccount fdd = null;
		try {
			fdd = (FixedDepositAccount) objectMessage.getObject();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		if (fdd != null) {
			createFixedDeposit(fdd);
		}
	}
}*/