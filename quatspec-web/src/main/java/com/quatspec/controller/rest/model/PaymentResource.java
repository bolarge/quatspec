package com.quatspec.controller.rest.model;

import java.math.BigDecimal;
import java.util.Date;

import com.quatspec.api.enums.PaymentStatus;
import com.quatspec.api.enums.PaymentType;
import com.quatspec.api.model.IPayment;

public class PaymentResource extends DefaultResource implements IPayment<UserResource> {
	
	private BigDecimal amount;
	
	private String paymentDescription;
	
	private Date paymentDate;
	
	private UserResource payer;
	
	private UserResource payee;
	
	private PaymentStatus paymentStatus;
	
	private PaymentType paymentType;
	
	public PaymentResource() {
		super();
	}
	
	public PaymentResource(IPayment paymentRequest) {
		this.amount = paymentRequest.getAmount();
		this.paymentDescription = paymentRequest.getPaymentDescription();
		if ((paymentRequest.getPayer() != null) && (paymentRequest.getPayee() != null)) {
			this.payer = new UserResource(paymentRequest.getPayer());
			this.payee = new UserResource(paymentRequest.getPayee());
		}
	}

	@Override
	public UserResource getPayer() {
		return payer;
	}

	@Override
	public void setPayer(UserResource iUser) {
		this.payer = iUser;
		
	}

	@Override
	public UserResource getPayee() {
		return payee;
	}

	@Override
	public void setPayee(UserResource iUser) {
		this.payee = iUser;
		
	}

	@Override
	public BigDecimal getAmount() {
		return amount;
	}

	@Override
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public String getPaymentDescription() {
		return paymentDescription;
	}

	@Override
	public void setPaymentDescription(String paymentDescription) {
		this.paymentDescription = paymentDescription;
	}

	@Override
	public Date getPaymentDate() {
		return paymentDate;
	}

	@Override
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Override
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	@Override
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public PaymentType getPaymentType() {
		return paymentType;
	}

	@Override
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

}
