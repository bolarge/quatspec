package com.quatspec.persistence.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.quatspec.api.model.IProduct;
import com.quatspec.persistence.domain.base.ProductParent;

@Entity(name = "ProductGoods")
@DiscriminatorValue(value = "1")
public class Product extends ProductParent implements IProduct<Organization>, Serializable {
	
	public Product() {
		super();
	}

	public Product(String productId, String name, String description) {
		super(productId, name, description);
	}
	
	public Product(String productId, String name, String description, Integer productClass, Organization organization) {
		super(productId, name, description, productClass, organization);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	@Override
	public Collection<Organization> getProducts() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
