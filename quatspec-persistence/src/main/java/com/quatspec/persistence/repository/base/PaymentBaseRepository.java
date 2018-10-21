package com.quatspec.persistence.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.quatspec.persistence.domain.Payment;

@NoRepositoryBean
public interface PaymentBaseRepository<T extends Payment> extends JpaRepository<T, Long> {

	public T findByPaymentId (String paymentId);
}
