package com.quatspec.service.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quatspec.api.exception.QuaspecServiceException;
import com.quatspec.api.model.IPayment;
import com.quatspec.api.model.IUser;
import com.quatspec.api.service.IPaymentService;
import com.quatspec.persistence.domain.Bill;
import com.quatspec.persistence.domain.Customer;
import com.quatspec.persistence.domain.Payment;
import com.quatspec.persistence.repository.DataAccessService;

@Service("paymentService")
public class PaymentServiceImpl implements IPaymentService{
	
	@Autowired
	DataAccessService dataAccessService;

	@Override
	public List<? extends IPayment<IUser>> getAll() throws QuaspecServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPayment get(String username) throws QuaspecServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment processPayment(IPayment paymentRequest) throws QuaspecServiceException {
		Customer payer = (Customer) paymentRequest.getPayer();//Get Payer
		Customer payee = (Customer) paymentRequest.getPayee();//Get Payee
		final String digest = UUID.randomUUID().toString().replace("-", "");
		
        if (paymentRequest.getPayer() != null) {
            if (paymentRequest.getPayee() != null) {
            	if(paymentRequest.getAmount() != new BigDecimal(0)) {
            		IPayment aBill = new Bill(digest,  paymentRequest.getAmount(), paymentRequest.getPaymentDescription(), paymentRequest.getPaymentDate(), payer, 
            				payee, paymentRequest.getPaymentStatus(), paymentRequest.getPaymentStatus(), paymentRequest.getPaymentType());
	                return dataAccessService.getPaymentRepository().save(aBill);
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
		Customer user = (Customer) dataAccessService.getUserRepository().findByUserName(username);
        if (user != null) {
            return dataAccessService.getPaymentRepository().findByPayer(user);
        }
        return new ArrayList<>();
	}

}
