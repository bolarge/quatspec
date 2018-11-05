package com.quatspec.controller.rest.model;

import java.util.ArrayList;
import java.util.Collection;

import com.quatspec.api.model.IProduct;

public class IProductResource extends DefaultResource implements IProduct<IOrganizationResource>{
	
	private String productId;
	
	private String name;
	
	private String description;
	
	private Integer productClass;
	
	private Collection<IProductResource> products = new ArrayList<IProductResource>();
	
	private IOrganizationResource organization;
	
	public IProductResource() {
		super();
	}
	
	public IProductResource(IProduct product) {
		this.productId = product.getProductId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.productClass = product.getProductClass();
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

	@Override
	public Integer getProductClass() {
		return productClass;
	}

	@Override
	public void setProductClass(Integer productClass) {
		this.productClass = productClass;
	}

	@Override
	public Collection<IOrganizationResource> getProducts() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
