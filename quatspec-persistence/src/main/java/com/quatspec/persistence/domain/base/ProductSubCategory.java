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
	protected Set<Product> products = new HashSet<Product>();
	
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

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
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

}
