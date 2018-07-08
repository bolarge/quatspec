package com.quatspec.persistence.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
