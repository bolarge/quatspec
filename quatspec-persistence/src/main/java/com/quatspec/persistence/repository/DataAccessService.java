package com.quatspec.persistence.repository;

public interface DataAccessService {

	public ProfileRepository getProfileRepository();

	public RoleRepository getRoleRepository();
	
	public InstitutionRepository getInstitutionRepository();
	
	public OrganizationRepository getOrganizationRepository();
	
	public EmployeeRepository getEmployeeRepository();
	
	public CustomerRepository getCustomerRepository();
	
	public UserRepository getUserRepository();
	
	public MenuRepository getMenuRepository();
	
	public SavingsAccountRepository getSavingsAccountRepository();
	
	public FixedDepositRepository getFixedDepositRepository();
	
	public BankAccountRepository getBankAccountRepository();
	
	public PaymentRepository getPaymentRepository();
}
