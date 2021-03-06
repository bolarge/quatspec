package com.quatspec.persistence.domain.base;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.quatspec.persistence.domain.Organization;

@Entity(name = "Product")
@Table(name = "product")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "p_type")
public abstract class ProductParent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected Long id;
	
	@Column(name="product_id")
	protected String productId;
	
	@Column(name="name")
	protected String name;
	
	@Column(name="description")
	protected String description;
	
	@Column(name="status")
    protected boolean status = true;
	
	@Column(name = "p_class")
	protected Integer productClass;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="organization_id")
	protected Organization organization;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "product_payment", 
		joinColumns = @JoinColumn(name = "product_id"), 
		inverseJoinColumns = @JoinColumn(nullable = false))*/
	
	/*@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="payment_id")
	protected PaymentParent payment;*/
	
	@ManyToMany(fetch=FetchType.LAZY,targetEntity=ProductSubCategory.class)
    @JoinTable(name="product_subcategory",
            joinColumns =@JoinColumn(name="product_id"),
            inverseJoinColumns=@JoinColumn(name="product_subcat_id"))
	protected Set<ProductSubCategory> productSubCategories = new HashSet<ProductSubCategory>();
	
	public ProductParent() {
		super();
	}

	public ProductParent(String productId, String name, String description) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
	}
	
	public ProductParent(String productId, String name, String description, Integer productClass, Organization organization) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.productClass = productClass;
		this.organization = organization;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Set<ProductSubCategory> getProductSubCategories() {
		return productSubCategories;
	}

	public void setProductSubCategories(Set<ProductSubCategory> productSubCategories) {
		this.productSubCategories = productSubCategories;
	}

	public Integer getProductClass() {
		return productClass;
	}

	public void setProductClass(Integer productClass) {
		this.productClass = productClass;
	}

	/*public PaymentParent getPayment() {
		return payment;
	}

	public void setPayment(PaymentParent payment) {
		this.payment = payment;
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
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
		ProductParent other = (ProductParent) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}
	
	

}
