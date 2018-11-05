package com.quatspec.api.model;

import java.util.Collection;
import java.util.Set;

public interface IOrganization<T extends IProduct> {

	String getName();
	
	void setName(String name);
	
	String getEmail();
	
	void setEmail(String Email);
	
	String getPhoneNumber();
	
	void setPhoneNumber(String phoneNumber);
	
	Collection<T> getProducts();
	
	void setProducts(Collection<T> products);

}
