package com.quatspec.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "FixedDepositAccount")
public class FixedDepositAccount extends BankAccount{
	
	@Column(name = "fixed_deposit_id", unique = true)
	private String fixedDepositId;

	@Column(name = "amount")
	private int fdAmount;

	@Column(name = "tenure")
	private int tenure;
	
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