package com.quatspec.api.service;

import java.util.List;

import com.quatspec.api.exception.QuaspecServiceException;
import com.quatspec.api.model.IPayment;

public interface IPaymentService {
	
	List<? extends IPayment> getAll() throws QuaspecServiceException;
	
	List<? extends IPayment> getByIUser(String username) throws QuaspecServiceException;
	
	IPayment get(String username) throws QuaspecServiceException;
	
	IPayment processPayment(IPayment payment) throws QuaspecServiceException;

}
