package com.quatspec.service.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.quatspec.persistence.domain.Employee;
import com.quatspec.service.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	@Override
	public List<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee findEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee findEmployeeByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*@PersistenceContext
	private EntityManager entityManager;*/

	

}
