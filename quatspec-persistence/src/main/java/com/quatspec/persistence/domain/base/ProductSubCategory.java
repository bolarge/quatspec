package com.quatspec.persistence.domain.base;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.quatspec.persistence.domain.Product;

@Entity(name = "ProductSubCategory")
@Table(name = "product_sub_category")
public class ProductSubCategory implements Comparable<ProductSubCategory>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	protected Integer Id;
	
	@Column(name = "name")
	protected String name;
	
	@Column(name = "category")
	protected String category;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_category_id")
	protected ProductCategory productCategory;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "productSubCategories")
	protected Set<ProductParent> products = new HashSet<ProductParent>();
	
	public ProductSubCategory() {
		super();
	}
	
	public ProductSubCategory(Integer id) {
		super();
		Id = id;
	}

	public ProductSubCategory(String name, ProductCategory productCategory) {
		super();
		this.name = name;
		this.productCategory = productCategory;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public Set<ProductParent> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductParent> products) {
		this.products = products;
	}

	@Override
	public int compareTo(ProductSubCategory o) {
		int compareId = ((ProductSubCategory) o).getId().intValue(); 
		 
		//ascending order
		return this.Id.intValue() - compareId;
 
		//descending order
		//return compareQuantity - this.quantity;
		//return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
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
		ProductSubCategory other = (ProductSubCategory) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}
