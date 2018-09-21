package com.quatspec.api.model;

import java.math.BigDecimal;
import java.util.Date;

import com.quatspec.api.enums.PaymentStatus;
import com.quatspec.api.enums.PaymentType;

public interface IPayment<T extends IUser> {
		
	T getPayer();

	void setPayer(T iUser) ;

	T getPayee() ;

	void setPayee(T iUser) ;

	BigDecimal getAmount() ;

	void setAmount(BigDecimal amount) ;

	String getPaymentDescription() ;

	void setPaymentDescription(String paymentDescription) ;

	Date getPaymentDate() ;

	void setPaymentDate(Date paymentDate) ;

	PaymentStatus getPaymentStatus() ;

	void setPaymentStatus(PaymentStatus paymentStatus);

	public PaymentType getPaymentType() ;

	public void setPaymentType(PaymentType paymentType);

}
