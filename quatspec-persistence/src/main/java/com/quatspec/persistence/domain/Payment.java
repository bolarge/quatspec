package com.quatspec.persistence.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.quatspec.api.enums.PaymentStatus;
import com.quatspec.api.enums.PaymentType;
import com.quatspec.api.model.IPayment;
import com.quatspec.persistence.domain.base.PaymentParent;

@Entity(name = "Payment")
@DiscriminatorValue(value = "1")
public class Payment extends PaymentParent implements IPayment<User>{
	
	public Payment() {}
	
	public Payment(String paymentId, BigDecimal amount, Double paymentCharge, String paymentDescription,
			Date paymentDate, User paychant, User merchant, PaymentStatus paymentStatus, PaymentType paymentType) {
		super(paymentId, amount, paymentCharge, paymentDescription, paymentDate, paychant, merchant, paymentStatus, paymentType);
	}

	public Payment(String digest, BigDecimal amount, String paymentDescription, User paychant, User merchant,
			PaymentType paymentType) {
		super(digest, amount, paymentDescription, paychant, merchant, paymentType);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getPaychant() {
		return paychant;
	}

	public void setPaychant(User paychant) {
		this.paychant = paychant;
	}

	public User getMerchant() {
		return merchant;
	}

	public void setMerchant(User merchant) {
		this.merchant = merchant;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getPaymentDescription() {
		return paymentDescription;
	}

	public void setPaymentDescription(String paymentDescription) {
		this.paymentDescription = paymentDescription;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

}
