package com.quatspec.persistence.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "Customer")
public class Customer extends User{

	@Column(name = "customer_id")
	private String customerId;
	
	public Customer() {}
	
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public String getEmployeeId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEmployeeId(String employeeId) {
		// TODO Auto-generated method stub
		
	}

}
