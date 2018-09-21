package com.quatspec.persistence.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "Customer")
@DiscriminatorValue(value = "CUS")
public class Customer extends User{

	@Column(name = "customer_id", unique = true)
	protected String customerId;
	
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
