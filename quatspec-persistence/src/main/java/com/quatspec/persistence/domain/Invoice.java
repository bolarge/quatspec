package com.quatspec.persistence.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.quatspec.api.model.IInvoice;

@Entity(name = "Invoice")
@DiscriminatorValue(value = "2")
public class Invoice extends Payment implements IInvoice<Product>{
	
	public Invoice() {
		super();
	}

	public Invoice(String paymentId, BigDecimal amount, Double paymentCharge, String paymentDescription, Set<Product> product, Date paymentDate, 
			User paychant, User merchant, String paymentType) {
		super(paymentId, amount, paymentCharge, paymentDescription, product, paymentDate, paychant, merchant, paymentType);
	}

	public Invoice(String digest, BigDecimal amount, String paymentDescription, User paychant, User merchant,
			String paymentType) {
		super(digest, amount, paymentDescription, paychant, merchant, paymentType);
	}

	
}
