package com.quaspec.controller.rest.model;

import java.util.Date;

import com.quaspec.api.model.IBankAccount;

public class BankAccountResource extends DefaultResource implements IBankAccount<UserResource> {

    private String accountNumber;

    private String bankVerificationNumber;
    
    private String accountType;

    private UserResource appUser;

    public BankAccountResource() {
        super();
    }

    public BankAccountResource(IBankAccount bankAccount) {
        this.accountNumber = bankAccount.getAccountNumber();
        if (bankAccount.getUser() != null) {
            this.appUser = new UserResource(bankAccount.getUser());
        }
    }
    
    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public UserResource getUser() {
        return appUser;
    }

    @Override
    public void setUser(UserResource appUser) {
        this.appUser = appUser;
    }

	@Override
	public int getBalanceAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setBalanceAmount(int balanceAmount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date getLastTransactionTimestamp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLastTransactionTimestamp(Date lastTransactionTimestamp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return 0L;
	}

	@Override
	public void setId(long accountId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date getCreationDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCreationDate(Date creationDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getActive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setActive(String active) {
		// TODO Auto-generated method stub
		
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

}
