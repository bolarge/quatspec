package com.quatspec.api.model;

import java.util.Set;

public interface IInvoice<T extends IProduct> {

	/*String getProductId();

	void setProductId(String productId);

	String getName();

	void setName(String name);

	String getDescription();

	void setDescription(String description);

	Integer getProductClass();

	void setProductClass(Integer productClass);*/
	
	Set<T> getProducts();
	
	void setProducts(Set<T> products);

}
