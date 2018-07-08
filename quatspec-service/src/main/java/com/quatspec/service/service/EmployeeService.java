package com.quatspec.service.service;

import java.util.List;

import com.quatspec.persistence.domain.Employee;

public interface EmployeeService {

	public List<Employee> findAllEmployees();
	public Employee findEmployeeById(Long id);
	public Employee createEmployee(Employee employee);
	public void deleteEmployee(Employee employee);
	public Employee findEmployeeByUserName(String userName);

}
