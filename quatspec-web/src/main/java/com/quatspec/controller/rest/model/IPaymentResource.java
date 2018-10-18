package com.quatspec.controller.rest.model;

import java.math.BigDecimal;
import java.util.Date;

import com.quatspec.api.enums.PaymentStatus;
import com.quatspec.api.enums.PaymentType;
import com.quatspec.api.model.IPayment;

public class IPaymentResource extends DefaultResource implements IPayment<IUserResource> {
	
	private BigDecimal amount;
	
	private String paymentDescription;
	
	private Date paymentDate;
	
	private IUserResource paychant;
	
	private IUserResource merchant;
	
	private PaymentStatus paymentStatus;
	
	private PaymentType paymentType;
	
	public IPaymentResource() {
		super();
	}
	
	public IPaymentResource(IPayment paymentRequest) {
		this.amount = paymentRequest.getAmount();
		this.paymentDescription = paymentRequest.getPaymentDescription();
		if ((paymentRequest.getPaychant() != null) && (paymentRequest.getMerchant() != null)) {
			this.paychant = new IUserResource(paymentRequest.getPaychant());
			this.merchant = new IUserResource(paymentRequest.getMerchant());
		}
	}

	@Override
	public IUserResource getPaychant() {
		return paychant;
	}

	@Override
	public void setPaychant(IUserResource paychant) {
		this.paychant = paychant;		
	}

	@Override
	public IUserResource getMerchant() {
		return merchant;
	}

	@Override
	public void setMerchant(IUserResource merchant) {
		this.merchant = merchant;	
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
