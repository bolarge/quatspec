package com.quatspec.persistence.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="SavingAccount")
@DiscriminatorValue(value = "SA")
public class SavingsAccount extends BankAccount{

	private int interestRate;
	
	 public SavingsAccount() {
	        super();
	    }

	public SavingsAccount(String accountNumber, User user) {
	        super(accountNumber, user);
	    }

	public int getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}
	
	@Override
	public String toString() {
		return "SavingsAccountDetails [SavingsAccountId=" + super.getId()
				+ ", accountOwner=" + super.getUser().getUserName()  + ", interestRate=" + interestRate +  "]";
	}

	@Override
	public boolean equals(Object obj) {
		SavingsAccount other = (SavingsAccount) obj;
		if (other.getAccountNumber() == super.getAccountNumber()) {
			return true;
		} else {
			return false;
		}
	}
	
}
