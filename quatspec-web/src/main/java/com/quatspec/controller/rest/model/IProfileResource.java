package com.quatspec.controller.rest.model;

import com.quatspec.api.model.IProfile;

public class IProfileResource extends DefaultResource implements IProfile{
	
	private String name;
	
	private String description;
	
	private String baseUrl;
	
	private boolean isStatus = false;
	
	public IProfileResource() {
		super();
	}
	
	public IProfileResource(IProfile profile) {
		this.name = profile.getName();
		//this.description = profile.getDescription();
		//this.baseUrl = profile.getBaseUrl();
		//this.isStatus = profile.isStatus();
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
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getBaseUrl() {
		return baseUrl;
	}

	@Override
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	@Override
	public boolean isStatus() {
		return isStatus;
	}

	@Override
	public void setStatus(boolean status) {
		this.isStatus = status;
	}

}
