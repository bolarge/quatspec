package com.quatspec.persistence.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quatspec.persistence.repository.BankAccountRepository;
import com.quatspec.persistence.repository.CustomerRepository;
import com.quatspec.persistence.repository.DataAccessService;
import com.quatspec.persistence.repository.EmployeeRepository;
import com.quatspec.persistence.repository.FixedDepositRepository;
import com.quatspec.persistence.repository.InstitutionRepository;
import com.quatspec.persistence.repository.MenuRepository;
import com.quatspec.persistence.repository.OrganizationRepository;
import com.quatspec.persistence.repository.PaymentRepository;
import com.quatspec.persistence.repository.ProfileRepository;
import com.quatspec.persistence.repository.RoleRepository;
import com.quatspec.persistence.repository.SavingsAccountRepository;
import com.quatspec.persistence.repository.UserRepository;

@Service("dataAccessService")
public class DataAccessServiceImpl implements DataAccessService{

	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private InstitutionRepository instituionRepository;
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	private SavingsAccountRepository savingsAccountRepository;
	
	@Autowired
	private FixedDepositRepository fixedDepositRepository;
	
	@Autowired
	private BankAccountRepository bankAccountRepository;
	
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
	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	@Override
	public CustomerRepository getCustomerRepository() {
		return customerRepository;
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
	public SavingsAccountRepository getSavingsAccountRepository() {
		return savingsAccountRepository;
	}

	@Override
	public FixedDepositRepository getFixedDepositRepository() {
		return fixedDepositRepository;
	}

	@Override
	public BankAccountRepository getBankAccountRepository() {
		return bankAccountRepository;
	}

	@Override
	public PaymentRepository getPaymentRepository() {
		return paymentRepository;
	}	
}
