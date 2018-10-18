package com.quatspec.persistence.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.quatspec.api.model.IPayment;
import com.quatspec.persistence.domain.Payment;
import com.quatspec.persistence.domain.User;
import com.quatspec.persistence.repository.base.PaymentBaseRepository;

@Transactional
public interface PaymentRepository extends PaymentBaseRepository<Payment>{

	IPayment save(IPayment payment);

	List<? extends IPayment> findByPaychant(User user);

	List<? extends IPayment> findByMerchant(User user);
	
}
