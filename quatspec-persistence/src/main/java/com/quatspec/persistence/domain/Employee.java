package com.quatspec.persistence.domain;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.quatspec.api.model.IProfile;

@Entity(name = "Employee")
@DiscriminatorValue(value = "2")
public class Employee extends User{
	
	@Column(name="employee_id", unique = true)
	private String employeeId;
	
	@Column(name="salary")
	private BigDecimal salary;
	
	@Column(name="pension")
	private long pension;
	
	@Column(name="vacation")
	private int vacation;
	
	public Employee() {
		super();
	}
	
	public Employee(String userName, String email, String password, String gsmPhoneNumber) {
		super(userName, email, password, gsmPhoneNumber);
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	
	public long getPension() {
		return pension;
	}
	public void setPension(long pension) {
		this.pension = pension;
	}
	
	public int getVacation() {
		return vacation;
	}

	public void setVacation(int vacation) {
		this.vacation = vacation;
	}

	@Override
	public String getUserType() {
		return null;
	}

	@Override
	public void setUserType(String userType) {
	
	}	
}