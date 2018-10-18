package com.quatspec.service.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quatspec.api.exception.QuaspecServiceException;
import com.quatspec.api.model.IPayment;
import com.quatspec.api.service.IPaymentService;
import com.quatspec.persistence.domain.Payment;
import com.quatspec.persistence.domain.User;
import com.quatspec.persistence.repository.DataAccessService;

@Service("paymentService")
public class PaymentServiceImpl implements IPaymentService{
	
	@Autowired
	DataAccessService dataAccessService;

	@Override
	public List<? extends IPayment> getAll() throws QuaspecServiceException {
		return dataAccessService.getPaymentRepository().findAll();
	}

	@Override
	public IPayment get(String username) throws QuaspecServiceException {
		return dataAccessService.getPaymentRepository().findByPaychant(
				dataAccessService.getUserRepository().findByUserName(username)).stream().findFirst().get();
	}

	@Override
	public Payment processPayment(IPayment iPaymentRequest) throws QuaspecServiceException {
		//Transaction will be sorted by Initiating/Receiving Bank & transaction type ON-US / NOT ON-US
		//ON US transaction will be routed to corresponding bank
		
		final String digest = UUID.randomUUID().toString().replace("-", "");	
		User paychant = (User) dataAccessService.getUserRepository().findByUserName((iPaymentRequest.getPaychant().getUserName()));
    	User merchant = (User) dataAccessService.getUserRepository().findByUserName((iPaymentRequest.getMerchant().getUserName()));
    	
        if (iPaymentRequest.getPaychant() != null && iPaymentRequest.getMerchant() != null) {        	
            if (paychant != null) {
            	if(iPaymentRequest.getAmount() != new BigDecimal(0)) {
            		Payment payment = new Payment(digest, iPaymentRequest.getAmount(), iPaymentRequest.getPaymentDescription(), paychant, 
            				merchant, iPaymentRequest.getPaymentType());
	                return dataAccessService.getPaymentRepository().save(payment);
            	}
            	/*else if(paymentRequest.getPaymentType().equalsIgnoreCase("F")) {
            		IPayment aBill = new Bill(digest,  paymentRequest.getAmount(), paymentRequest.getPaymentDescription(), paymentRequest.getPaymentDate(), payer, 
            				payee, paymentRequest.getPaymentStatus(), paymentRequest.getPaymentStatus(), paymentRequest.getPaymentType());
	                return dataAccessService.getPaymentRepository().save(aBill);
            	}*/
            }
        }
        return null;		
	}

	@Override
	public List<? extends IPayment> getByIUser(String username) throws QuaspecServiceException {
		User user = (User) dataAccessService.getUserRepository().findByUserName(username);
        if (user != null) {
            return dataAccessService.getPaymentRepository().findByPaychant(user);
        }
        return new ArrayList<>();
	}
}
