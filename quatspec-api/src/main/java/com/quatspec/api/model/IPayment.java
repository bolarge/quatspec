package com.quatspec.api.model;

import java.math.BigDecimal;

import java.util.Date;

import com.quatspec.api.enums.PaymentStatus;

public interface IPayment<T extends IUser> {
		
	T getPaychant();

	void setPaychant(T paychant) ;

	T getMerchant() ;

	void setMerchant(T merchant) ;

	BigDecimal getAmount() ;

	void setAmount(BigDecimal amount) ;

	String getPaymentDescription() ;

	void setPaymentDescription(String paymentDescription) ;

	Date getPaymentDate() ;

	void setPaymentDate(Date paymentDate) ;

	PaymentStatus getPaymentStatus() ;

	void setPaymentStatus(PaymentStatus paymentStatus);
	
	String getPaymentType() ;

	void setPaymentType(String paymentType);
	
	/*Set<T> getProducts();

	void setProducts(Set<T> products) ;*/
	

}
