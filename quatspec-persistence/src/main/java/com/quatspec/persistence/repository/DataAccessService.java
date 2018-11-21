package com.quatspec.persistence.repository;

public interface DataAccessService {

	public ProfileRepository getProfileRepository();

	public RoleRepository getRoleRepository();
	
	public InstitutionRepository getInstitutionRepository();
	
	public OrganizationRepository getOrganizationRepository();
	
	public UserRepository getUserRepository();
	
	public MenuRepository getMenuRepository();
	
	//public FixedDepositRepository getFixedDepositRepository();
	
	public BankAccountRepository getBankAccountRepository();
	
	public PaymentRepository getPaymentRepository();
	
	public ProductRepository getProductRepository();
}
