package com.quatspec.controller.rest.model;

import java.util.ArrayList;
import java.util.Collection;

import com.quatspec.api.model.IInvoice;

public class IInvoiceResource extends DefaultResource implements IInvoice<IProductResource>{

	private Collection<IProductResource> products = new ArrayList<IProductResource>();

	public IInvoiceResource() {
		super();
	}

	public IInvoiceResource(IInvoice<IProductResource> invoice) {		
		if(!invoice.getProducts().isEmpty()) {	
			this.products = invoice.getProducts();		
		}				
	}

	@Override
	public Collection<IProductResource> getProducts() {
		return products;
	}

	@Override
	public void setProducts(Collection<IProductResource> products) {
		this.products = products;
	}
}
