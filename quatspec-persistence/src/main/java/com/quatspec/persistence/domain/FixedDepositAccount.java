package com.quatspec.persistence.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "FixedDepositAccount")
@DiscriminatorValue(value = "FD")
public class FixedDepositAccount extends BankAccount{
	
	@Column(name = "fixed_deposit_id", unique = true)
	private String fixedDepositId;

	@Column(name = "amount")
	private int fdAmount;

	@Column(name = "tenure")
	private int tenure;
	
	@Column(name = "bank_account_id")
	private int bankAccountId;

	@Column(name = "email")
	private String email;
	
	public FixedDepositAccount() {
        super();
    }

	public FixedDepositAccount(String accountNumber, User user) {
        super(accountNumber, user);
    }

	public void setFixedDepositId(String fixedDepositId) {
		this.fixedDepositId = fixedDepositId;
	}

	public String getFixedDepositId() {
		return fixedDepositId;
	}

	public int getFdAmount() {
		return fdAmount;
	}

	public void setFdAmount(int fdAmount) {
		this.fdAmount = fdAmount;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	

	public int getBankAccountId() {
		return bankAccountId;
	}

	public void setBankAccountId(int bankAccountId) {
		this.bankAccountId = bankAccountId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "FixedDepositDetails [fixedDepositId=" + fixedDepositId
				+ ", accountOwner=" + super.getUser().getUserName()  + ", fdAmount=" + fdAmount + ", tenure="
				+ tenure +  "]";
	}

	@Override
	public boolean equals(Object obj) {
		FixedDepositAccount other = (FixedDepositAccount) obj;
		if (other.getFixedDepositId() == this.fixedDepositId) {
			return true;
		} else {
			return false;
		}
	}

}