package com.quatspec.service.financial;

import com.quatspec.api.service.IBankAccountService;
import com.quatspec.api.service.IOrganizationService;
import com.quatspec.api.service.IPaymentService;
import com.quatspec.api.service.IProductService;
import com.quatspec.api.service.IUserService;

public interface FinancialPaymentsService {
	
	public IBankAccountService getBankService();
	
	public IPaymentService getPaymentService();
	
	public IOrganizationService getOrganizationService();
	
	public IProductService getProductService();
	
	public IUserService getUserService();

}
