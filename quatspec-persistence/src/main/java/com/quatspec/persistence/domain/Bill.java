package com.quatspec.persistence.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.quatspec.api.enums.PaymentStatus;
import com.quatspec.api.enums.PaymentType;

@Entity(name = "Bill")
@DiscriminatorValue(value = "BL")
public class Bill extends Payment{

	public Bill() {
		super();
	}

	public Bill(String paymentId, BigDecimal amount, Double paymentCharge, String paymentDescription, Date paymentDate,
			Customer payer, Customer payee, PaymentStatus paymentStatus, PaymentType paymentType) {
		super(paymentId, amount, paymentCharge, paymentDescription, paymentDate, payer, payee, paymentStatus, paymentType);
		
	}

	public Bill(String digest, BigDecimal amount, String paymentDescription, Date paymentDate, Customer payer,
			Customer payee, PaymentStatus paymentStatus, PaymentStatus paymentStatus2, PaymentType paymentType) {
		// TODO Auto-generated constructor stub
	}
	
	

}
