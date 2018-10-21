package com.quatspec.controller.rest.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.quatspec.api.enums.PaymentStatus;
import com.quatspec.api.model.IInvoice;
import com.quatspec.api.model.IPayment;
import com.quatspec.api.model.IProduct;

public class IPaymentResource extends DefaultResource implements IPayment<IUserResource>, IInvoice<IProductResource> {
	
	private BigDecimal amount;
	
	private String paymentDescription;
	
	private Date paymentDate;
	
	private IUserResource paychant;
	
	private IUserResource merchant;
	
	private PaymentStatus paymentStatus;
	
	private String paymentType;
	
	private Set<IProductResource> products;
	
	public IPaymentResource() {
		super();
	}
	
	public IPaymentResource(IPayment iPaymentRequest) {
		this.amount = iPaymentRequest.getAmount();
		this.paymentDescription = iPaymentRequest.getPaymentDescription();
		this.paymentType = iPaymentRequest.getPaymentType();
		
		if ((iPaymentRequest.getPaychant() != null) && (iPaymentRequest.getMerchant() != null)) {
			this.paychant = new IUserResource(iPaymentRequest.getPaychant());
			this.merchant = new IUserResource(iPaymentRequest.getMerchant());
		}
		
		//Having issues here to revisit
		/*if(!iPaymentRequest.getMerchant().getProducts().isEmpty()) {
		//if(!iPaymentRequest.getProducts().isEmpty()) {
			products = new HashSet<IProductResource>();
			products.addAll(iPaymentRequest.get);
			//((IProductResource) this.products).setProducts(iPaymentRequest.getMerchant().getOrganization().getProducts());					
		}*/
	}

	@Override
	public IUserResource getPaychant() {
		return paychant;
	}

	@Override
	public void setPaychant(IUserResource paychant) {
		this.paychant = paychant;		
	}

	@Override
	public IUserResource getMerchant() {
		return merchant;
	}

	@Override
	public void setMerchant(IUserResource merchant) {
		this.merchant = merchant;	
	}

	@Override
	public BigDecimal getAmount() {
		return amount;
	}

	@Override
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public String getPaymentDescription() {
		return paymentDescription;
	}

	@Override
	public void setPaymentDescription(String paymentDescription) {
		this.paymentDescription = paymentDescription;
	}

	@Override
	public Date getPaymentDate() {
		return paymentDate;
	}

	@Override
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Override
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	@Override
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String getPaymentType() {
		return paymentType;
	}

	@Override
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	@Override
	public Set<IProductResource> getProducts() {
		return products;
	}

	@Override
	public void setProducts(Set<IProductResource> products) {
		this.products.addAll(products);
	}

}
