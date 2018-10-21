package com.quatspec.persistence.domain.base;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "ProductCategory")
@Table(name = "product_category")
public class ProductCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	protected Integer id;
	
	@Column(name = "name")
	protected String name;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="productCategory", cascade=CascadeType.ALL, orphanRemoval=true)
	protected Set<ProductSubCategory> productSubCategories = new HashSet<ProductSubCategory>();

	public ProductCategory() {
		super();
	}

	public ProductCategory(String name, Set<ProductSubCategory> productSubCategories) {
		super();
		this.name = name;
		this.productSubCategories = productSubCategories;
	}

	public ProductCategory(String name) {
		super();
		this.name = name;
	}

	public ProductCategory(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ProductSubCategory> getProductSubCategories() {
		return productSubCategories;
	}

	public void setProductSubCategories(Set<ProductSubCategory> productSubCategories) {
		this.productSubCategories = productSubCategories;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductCategory other = (ProductCategory) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}
