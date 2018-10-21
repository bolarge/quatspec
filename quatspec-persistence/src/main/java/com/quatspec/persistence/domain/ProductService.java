package com.quatspec.persistence.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "ProductService")
@DiscriminatorValue(value = "2")
public class ProductService extends Product{

	public ProductService() {
		super();
	}
	
	public ProductService(String productId, String name, String description, Integer productClass, Organization organization) {
		super(productId, name, description, productClass, organization);
	}
}
