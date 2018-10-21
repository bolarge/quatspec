package com.quatspec.api.model;

import java.util.Set;

public interface Payable<Product> {

	Set<Product> getProduct();
	
	void setProduct(Set<Product> product);
}
