package com.quatspec.api.model;

import java.util.Collection;

public interface Payable<Product> {

	Collection<Product> getProducts();
	
	//void setProducts(Collection<Product> product);
}
