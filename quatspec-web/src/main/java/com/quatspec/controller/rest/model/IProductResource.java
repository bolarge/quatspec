package com.quatspec.controller.rest.model;

import com.quatspec.api.model.IProduct;

public class IProductResource extends DefaultResource implements IProduct<IOrganizationResource>{
	
	private String productId;
	
	private String name;
	
	private String description;
	
	private IOrganizationResource organization;
	
	public IProductResource() {
		super();
	}
	
	public IProductResource(IProduct product) {
		this.productId = product.getProductId();
		this.name = product.getName();
		this.description = product.getDescription();
		if(product.getOrganization() != null) {
		this.organization = new IOrganizationResource(product.getOrganization());
		}
	}

	@Override
	public String getProductId() {
		return productId;
	}

	@Override
	public void setProductId(String productId) {
		this.productId = productId;
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
	public IOrganizationResource getOrganization() {
		return organization;
	}

	@Override
	public void setOrganization(IOrganizationResource organization) {
		this.organization = organization;
	}	
}
