package com.quatspec.service.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quatspec.api.enums.PaymentStatus;
import com.quatspec.api.enums.PaymentType;
import com.quatspec.api.exception.QuaspecServiceException;
import com.quatspec.api.model.IInvoice;
import com.quatspec.api.model.IPayment;
import com.quatspec.api.service.IPaymentService;
import com.quatspec.persistence.domain.Payment;
import com.quatspec.persistence.domain.Product;
import com.quatspec.persistence.domain.User;
import com.quatspec.persistence.domain.base.ProductParent;
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
	public IPayment processPayment(IPayment iPaymentRequest) throws QuaspecServiceException {
		//Transaction will be sorted by Initiating/Receiving Bank & transaction type
		//Invoices is to be generated immediately
		//ON US transaction will be relayed to Bank through Integration to a service
		//NOT ON US transaction will be routed through integration to NIBSS for onward relay to Beneficiary bank
		
		final String digest = UUID.randomUUID().toString().replace("-", "");	
		User paychant = (User) dataAccessService.getUserRepository().findByEmail((iPaymentRequest.getPaychant().getEmail()));
    	User merchant = (User) dataAccessService.getUserRepository().findByEmail((iPaymentRequest.getMerchant().getEmail()));
    	Double charge = 1.2 ; 
    	Payment payment;
    	  	
        if (paychant != null && merchant != null) {        	          
            	if(iPaymentRequest.getAmount() != new BigDecimal(0)) {        
            		Collection<Product> product = new ArrayList<Product>();
            		if(iPaymentRequest.getProducts() != null) {
            			Iterator productIter = iPaymentRequest.getProducts().iterator();
            			while(productIter.hasNext()) {
            				Product prod = (Product) productIter.next();
            				prod = dataAccessService.getProductRepository().findByProductId(prod.getProductId());
            				product.add(prod);
            			}
            		}            		
            		 payment = new Payment(digest, iPaymentRequest.getAmount(), charge, iPaymentRequest.getPaymentDescription(), product,
            				new Date(), paychant, merchant, PaymentType.INVOICE, PaymentStatus.INITIATED);  
            		
            		//payment = dataAccessService.getPaymentRepository().save(payment);
            		//payment.getProducts().addAll(product);      		
            		//dataAccessService.getPaymentRepository().save(payment);
	                return dataAccessService.getPaymentRepository().save(payment);
            	}
            	//Prepare payment request to be sent to Bank or NIBSS Consume web service interface
            	
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

	@Override
	public IInvoice generateInvoice(IInvoice iProductInvoice) {
		// TODO Auto-generated method stub
		return null;
	}
}
