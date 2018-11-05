package com.quatspec.api.model;

public interface IProduct<T extends IOrganization> extends Payable {

	String getProductId();
	
	void setProductId(String productId);
	
	String getName();
	
	void setName(String name);
	
	String getDescription();
	
	void setDescription(String description);
	
	T getOrganization();
	
	void setOrganization(T organization);
	
	Integer getProductClass();
	
	void setProductClass(Integer productClass);
		
}
