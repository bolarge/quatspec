package com.quaspec.api.model;

public interface IPayment {
	
	FinancialAmount getAmount();
	
	void setAmount(FinancialAmount amount);

}
