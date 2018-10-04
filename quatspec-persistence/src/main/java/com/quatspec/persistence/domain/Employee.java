package com.quatspec.persistence.domain;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "Employee")
@DiscriminatorValue(value = "EMP")
public class Employee extends User{
	
	@Column(name="employee_id", unique = true)
	private String employeeId;
	
	@Column(name="salary")
	private BigDecimal salary;
	
	@Column(name="pension")
	private long pension;
	
	@Column(name="vacation")
	private int vacation;
	
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
	
	
	/*@ManyToMany(fetch=FetchType.EAGER, targetEntity = Profile.class)
	@JoinTable(name = "employee_profile_mapping",
			joinColumns = { @JoinColumn(name = "employee_id") },
			inverseJoinColumns = { @JoinColumn(name = "profile_id") })
	protected Set<Profile> profiles = new HashSet<Profile>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "employee_role_mapping",
	           joinColumns = @JoinColumn(name = "employee_id"), 
	           inverseJoinColumns = @JoinColumn(name = "role_id"))
	protected Set<Role> roles = new HashSet<Role>();*/

}