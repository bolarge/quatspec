package com.quatspec.controller.rest.model;

import com.quatspec.api.model.IOrganization;

public class IOrganizationResource extends DefaultResource implements IOrganization{
	
	private String name;
	
	private String email;
	
	private String phoneNumber;
	
	public IOrganizationResource() {
		super();
	}

	public IOrganizationResource(IOrganization organization) {
		this.name = organization.getName();
		this.email = organization.getEmail();
		this.phoneNumber = organization.getPhoneNumber();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;	
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Override
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
