
package com.quatspec.persistence.domain;

import java.util.Date;

import javax.persistence.*;

import com.quatspec.api.model.IBankAccount;
import com.quatspec.persistence.domain.base.AccountParent;

@Entity(name = "BankAccount")
@DiscriminatorValue(value = "1")
public class BankAccount extends AccountParent implements IBankAccount<User> {
	
    public BankAccount() {
        super();
    }

    public BankAccount(String accountNumber, String bvn, User user) {
    	super(accountNumber, bvn, user);
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
	public Long getAccountId() {
		return accountId;
	}

    @Override
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

    @Override
	public int getBalanceAmount() {
		return balanceAmount;
	}

    @Override
	public void setBalanceAmount(int balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

    @Override
	public Date getLastTransactionTimestamp() {
		return lastTransactionTimestamp;
	}

    @Override
	public void setLastTransactionTimestamp(Date lastTransactionTimestamp) {
		this.lastTransactionTimestamp = lastTransactionTimestamp;
	}
	
    @Override
	public Date getCreationDate() {
		return creationDate;
	}

    @Override
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
    @Override
	public String getActive() {
		return active;
	}

    @Override
	public void setActive(String active) {
		this.active = active;
	}

    @Override
	public String getBankVerificationNumber() {
		return bankVerificationNumber;
	}

    @Override
	public void setBankVerificationNumber(String bankVerificationNumber) {
		this.bankVerificationNumber = bankVerificationNumber;
	}
	
    @Override
	public String getAccountType() {
		return accountType;
	}

	@Override
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public String getApplicantId() {
		return null;
	}

	@Override
	public void setApplicantId(String applicantId) {
		
	}	
}
