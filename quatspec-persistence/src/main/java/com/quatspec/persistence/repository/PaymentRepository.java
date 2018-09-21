package com.quatspec.persistence.repository;

import java.util.List;

import com.quatspec.api.model.IPayment;
import com.quatspec.persistence.domain.Customer;
import com.quatspec.persistence.domain.Payment;
import com.quatspec.persistence.repository.base.PaymentBaseRepository;

public interface PaymentRepository extends PaymentBaseRepository<Payment>{

	Payment save(IPayment payment);

	List<? extends IPayment> findByPayee(Customer user);

	List<? extends IPayment> findByPayer(Customer user);
	
}
