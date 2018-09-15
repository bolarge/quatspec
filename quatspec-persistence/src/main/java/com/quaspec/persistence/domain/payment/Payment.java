package com.quaspec.persistence.domain.payment;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.quaspec.persistence.domain.Customer;
import com.quaspec.persistence.domain.FinancialAmount;

@Entity(name = "Payemnt")
@Table(name = "payment")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "payment_class")
public abstract class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	private FinancialAmount amount;
	private Customer initiator, beneficiary;
	
	public Payment() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public FinancialAmount getAmount()
	{
		return amount;
	}

	public void setAmount(FinancialAmount amount)
	{
		this.amount = amount;
	}

	public Customer getInitiator() {
		return initiator;
	}

	public void setInitiator(Customer initiator) {
		this.initiator = initiator;
	}

	public Customer getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Customer beneficiary) {
		this.beneficiary = beneficiary;
	}
	   
	

}
