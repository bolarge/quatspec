package com.quatspec.persistence.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.quatspec.api.enums.PaymentStatus;
import com.quatspec.api.enums.PaymentType;
import com.quatspec.api.model.IPayment;
import com.quatspec.api.model.IUser;
import com.quatspec.persistence.domain.base.PaymentParent;

@Entity(name = "Payment")
@DiscriminatorValue(value = "1")
public class Payment extends PaymentParent implements IPayment, Serializable{
	
	public Payment() {}

	public Payment(String paymentId, BigDecimal amount, Double paymentCharge, String paymentDescription,
			Collection<Product> product, Date paymentDate, User paychant, User merchant, PaymentType paymentType,
			PaymentStatus paymentStatus) {
		super(paymentId, amount, paymentCharge, paymentDescription, product, paymentDate, paychant, merchant, paymentType,
				paymentStatus);
	}

	public Payment(String paymentId, BigDecimal amount, Double paymentCharge, String paymentDescription,
			Date paymentDate, User paychant, User merchant, PaymentType paymentType, PaymentStatus paymentStatus) {
		super(paymentId, amount, paymentCharge, paymentDescription, paymentDate, paychant, merchant, paymentType,
				paymentStatus);
	}

	public Payment(String paymentId, BigDecimal amount, String paymentDescription, User paychant, User merchant,
			PaymentType paymentType, PaymentStatus paymentStatus) {
		super(paymentId, amount, paymentDescription, paychant, merchant, paymentType, paymentStatus);
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

	@Override
	public void setPaychant(IUser paychant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMerchant(IUser merchant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Product> getProducts() {
		return super.getProducts();
	}

	@Override
	public void setProducts(Collection<Product> products) {
		super.setProducts(products);
	}
	
		
}
