package com.quatspec.controller.rest.model;

import java.util.ArrayList;
import java.util.Collection;

import com.quatspec.api.model.IProduct;

public class IProductServiceResource extends IProductResource {
	
	private Collection<IProductServiceResource> productServices = new ArrayList<IProductServiceResource>();

	public IProductServiceResource() {
		super();
	}

	public IProductServiceResource(IProduct product) {
		super(product);
	}

}
