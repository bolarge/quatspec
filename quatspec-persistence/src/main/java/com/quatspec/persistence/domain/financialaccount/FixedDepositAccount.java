package com.quatspec.persistence.domain.financialaccount;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.quatspec.persistence.domain.User;

@Entity(name = "FixedDepositAccount")
@DiscriminatorValue(value = "2")
public class FixedDepositAccount extends BankAccount{	

	@Column(name = "fixed_deposit_id", unique = true, nullable = false)
	protected String fixedDepositId;
	 
	@Column(name = "amount")
	private double fixedAmount;

	@Column(name = "tenure")
	private int tenure;
	
	@Column(name = "email")
	private String email;
	
	public FixedDepositAccount() {
        super();
    }

	public FixedDepositAccount(String accountNumber,String bvn, User user, double fixedAmount) {
        super(accountNumber, bvn, user);
        this.fixedAmount = fixedAmount;
    }

	public FixedDepositAccount(String accountNumber, String bvn, User user) {
		super(accountNumber, bvn, user);
	}

	public String getFixedDepositId() {
		return fixedDepositId;
	}

	public void setFixedDepositId(String fixedDepositId) {
		this.fixedDepositId = fixedDepositId;
	}

	public void setFixedAmount(double fixedAmount) {
		this.fixedAmount = fixedAmount;
	}

	public double getFixedAmount() {
		return fixedAmount;
	}

	public void setFixedAmount(int fdAmount) {
		this.fixedAmount = fdAmount;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "FixedDepositDetails [fixedDepositId=" + accountNumber
				+ ", accountOwner=" + super.getUser().getUserName()  + ", fdAmount=" + fixedAmount + ", tenure="
				+ tenure +  "]";
	}

	@Override
	public boolean equals(Object obj) {
		FixedDepositAccount other = (FixedDepositAccount) obj;
		if (other.getAccountNumber() == this.accountNumber) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getApplicantId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setApplicantId(String applicantId) {
		// TODO Auto-generated method stub
		
	}

}