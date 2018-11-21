package com.quatspec.persistence.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quatspec.persistence.repository.BankAccountRepository;
import com.quatspec.persistence.repository.DataAccessService;
import com.quatspec.persistence.repository.InstitutionRepository;
import com.quatspec.persistence.repository.MenuRepository;
import com.quatspec.persistence.repository.OrganizationRepository;
import com.quatspec.persistence.repository.PaymentRepository;
import com.quatspec.persistence.repository.ProductRepository;
import com.quatspec.persistence.repository.ProfileRepository;
import com.quatspec.persistence.repository.RoleRepository;
import com.quatspec.persistence.repository.UserRepository;

@Service("dataAccessService")
public class DataAccessServiceRegistry implements DataAccessService{

	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private InstitutionRepository instituionRepository;
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	private BankAccountRepository bankAccountRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;

	public ProfileRepository getProfileRepository() {
		return profileRepository;
	}

	public RoleRepository getRoleRepository() {
		return roleRepository;
	}

	public InstitutionRepository getInstitutionRepository() {
		return instituionRepository;
	}

	public OrganizationRepository getOrganizationRepository() {
		return organizationRepository;
	}

	@Override
	public UserRepository getUserRepository() {
		return userRepository;
	}

	@Override
	public MenuRepository getMenuRepository() {
		return menuRepository;
	}

	@Override
	public BankAccountRepository getBankAccountRepository() {
		return bankAccountRepository;
	}

	@Override
	public PaymentRepository getPaymentRepository() {
		return paymentRepository;
	}

	@Override
	public ProductRepository getProductRepository() {
		return productRepository;
	}	
}
