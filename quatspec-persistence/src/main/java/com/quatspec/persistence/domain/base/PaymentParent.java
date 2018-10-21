package com.quatspec.persistence.domain.base;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.quatspec.api.enums.PaymentStatus;
import com.quatspec.api.enums.PaymentType;
import com.quatspec.persistence.domain.Product;
import com.quatspec.persistence.domain.User;

@Entity(name = "PaymentParent")
@Table(name = "payment")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "p_type")
public abstract class PaymentParent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected Long id;

	@Column(name = "payment_id")
	protected String paymentId;

	@Column(name = "amount")
	protected BigDecimal amount;

	@Column(name = "payment_charge")
	protected Double paymentCharge;

	@Column(name = "payment_description")
	protected String paymentDescription;

	@Column(name = "payment_date")
	protected Date paymentDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payer", referencedColumnName = "id", nullable = false)
	protected User paychant;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payee", referencedColumnName = "id", nullable = false)
	protected User merchant;

	@Enumerated(EnumType.STRING)
	protected PaymentStatus paymentStatus;

	//@Enumerated(EnumType.STRING)
	protected String paymentType;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
	protected Set<Product> products = new HashSet<Product>();

	public PaymentParent() {}

	public PaymentParent(String paymentId, BigDecimal amount, Double paymentCharge, String paymentDescription, Set<Product> product,
			Date paymentDate, User paychant, User merchant, String paymentType) {
		this.paymentId = paymentId;
		this.amount = amount;
		this.paymentCharge = paymentCharge;
		this.paymentDescription = paymentDescription;
		this.products = product;
		this.paymentDate = paymentDate;
		this.paychant = paychant;
		this.merchant = merchant;
		this.paymentType = paymentType;
	}

	public PaymentParent(String paymentId, BigDecimal amount, String paymentDescription, User paychant, User merchant,
			String paymentType) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.paymentDescription = paymentDescription;
		this.paychant = paychant;
		this.merchant = merchant;
		this.paymentType = paymentType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getPaychant() {
		return paychant;
	}

	public void setPaychant(User paychant) {
		this.paychant = paychant;
	}

	public User getMerchant() {
		return merchant;
	}

	public void setMerchant(User merchant) {
		this.merchant = merchant;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getPaymentDescription() {
		return paymentDescription;
	}

	public void setPaymentDescription(String paymentDescription) {
		this.paymentDescription = paymentDescription;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public Double getPaymentCharge() {
		return paymentCharge;
	}

	public void setPaymentCharge(Double paymentCharge) {
		this.paymentCharge = paymentCharge;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((paymentId == null) ? 0 : paymentId.hashCode());
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
		PaymentParent other = (PaymentParent) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (paymentId == null) {
			if (other.paymentId != null)
				return false;
		} else if (!paymentId.equals(other.paymentId))
			return false;
		return true;
	}
	
	

}
