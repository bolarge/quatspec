package com.quaspec.service.service;

import java.util.List;

import com.quaspec.persistence.domain.Employee;

public interface EmployeeService {

	public List<Employee> findAllEmployees();
	public Employee findEmployeeById(Long id);
	public Employee createEmployee(Employee employee);
	public void deleteEmployee(Employee employee);
	public Employee findEmployeeByUserName(String userName);

}
