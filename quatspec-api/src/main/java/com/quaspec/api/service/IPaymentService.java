package com.quaspec.api.service;

import com.quaspec.api.model.FinancialAmount;

public interface IPaymentService {
	
	  public void processPayment(FinancialAmount amount, String initiator, String beneficiary);

		  /*public void processPayment(CreditCardPayment creditCardPayment) {
		    // process payment for CreditCardPayment
		  }

		  public void processPayment(PaypalPayment payment) {
		    // process payment for PaypalPayment
		  }
		  
		   public void processPayment(Invoice invoice) {
    // process payment for Invoice
  }
		  
		  */

}
