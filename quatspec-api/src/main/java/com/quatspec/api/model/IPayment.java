package com.quatspec.api.model;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;


public interface IPayment<T extends IUser>{ 
	
	Collection<IProduct> getProducts();
		
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

	/*PaymentStatus getPaymentStatus() ;

	void setPaymentStatus(PaymentStatus paymentStatus);
	
	PaymentType getPaymentType();

	void setPaymentType(PaymentType paymentType);*/

}
