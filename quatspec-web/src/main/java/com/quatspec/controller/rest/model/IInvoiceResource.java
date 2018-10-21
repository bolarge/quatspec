package com.quatspec.controller.rest.model;

import java.util.HashSet;
import java.util.Set;

import com.quatspec.api.model.IInvoice;

public class IInvoiceResource extends DefaultResource implements IInvoice<IProductResource>{

	/*private String productId;
	
	private String name;
	
	private String description;
	
	private Integer productClass;*/
	
	private Set<IProductResource> products = new HashSet<IProductResource>();

	public IInvoiceResource() {
		super();
	}

	public IInvoiceResource(IInvoice invoice) {
		/*this.productId = invoice.getProductId();
		this.name = invoice.getName();
		this.description = invoice.getDescription();
		this.productClass = invoice.getProductClass();*/
		
		this.products.addAll(invoice.getProducts());
	}
	
	/*@Override
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
	public Integer getProductClass() {
		return productClass;
	}

	@Override
	public void setProductClass(Integer productClass) {
		this.productClass = productClass;
	}*/

	@Override
	public Set<IProductResource> getProducts() {
		return products;
	}

	@Override
	public void setProducts(Set<IProductResource> products) {
		this.products.addAll(products);		
	}
}
