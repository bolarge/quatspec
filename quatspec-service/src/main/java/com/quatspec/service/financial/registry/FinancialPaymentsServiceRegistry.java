package com.quatspec.service.financial.registry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.quatspec.api.service.IBankAccountService;
import com.quatspec.api.service.IOrganizationService;
import com.quatspec.api.service.IPaymentService;
import com.quatspec.api.service.IProductService;
import com.quatspec.api.service.IUserService;
import com.quatspec.service.financial.FinancialPaymentsService;

@Service("financialServiceRegistry")
public class FinancialPaymentsServiceRegistry implements FinancialPaymentsService{
	
	@Autowired
    @Qualifier("bankAccountService")
    private IBankAccountService iBankAccountService;
	
	@Autowired
    @Qualifier("paymentService")
	private IPaymentService iPaymentService;
	
	@Autowired
    @Qualifier("productService")
	private IProductService iProductService;
	
	@Autowired
    @Qualifier("organizationService")
	private IOrganizationService iOrganizationService;
	
	@Autowired
    @Qualifier("userService")
	private IUserService iUserService;

	@Override
	public IBankAccountService getBankService() {
		return iBankAccountService;
	}

	@Override
	public IPaymentService getPaymentService() {
		return iPaymentService;
	}

	@Override
	public IOrganizationService getOrganizationService() {
		return iOrganizationService;
	}

	@Override
	public IProductService getProductService() {
		return iProductService;
	}

	@Override
	public IUserService getUserService() {
		return iUserService;
	}

}
