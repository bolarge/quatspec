package com.quatspec.controller.rest.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.quatspec.api.enums.PaymentType;
import com.quatspec.api.model.IPayment;
import com.quatspec.api.model.Payable;
import com.quatspec.persistence.domain.Product;

public class IPaymentResource extends DefaultResource implements IPayment<IUserResource>, Payable {
	
	private BigDecimal amount;
	
	private String paymentDescription;
	
	private Date paymentDate;
	
	private IUserResource paychant;
	
	private IUserResource merchant;
	
	//private PaymentStatus paymentStatus;
	
	private PaymentType paymentType;
	
	//@JsonIgnore
	private Collection<Product> products = new ArrayList<Product>();
	
	public IPaymentResource() {
		super();
	}
	
	public IPaymentResource(IPayment iPaymentRequest) {
		this.amount = iPaymentRequest.getAmount();
		this.paymentDescription = iPaymentRequest.getPaymentDescription();
		//this.paymentType = iPaymentRequest.getPaymentType();
		
		if ((iPaymentRequest.getPaychant() != null) && (iPaymentRequest.getMerchant() != null)) {
			this.paychant = new IUserResource(iPaymentRequest.getPaychant());
			this.merchant = new IUserResource(iPaymentRequest.getMerchant());
		}
		
		if(!iPaymentRequest.getProducts().isEmpty()) {	
			this.products = iPaymentRequest.getProducts();				
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

	/*@Override
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
	}*/

	@Override
	public Collection getProducts() {
		return products;
	}

}
