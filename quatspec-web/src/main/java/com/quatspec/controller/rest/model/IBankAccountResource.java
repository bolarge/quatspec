package com.quatspec.controller.rest.model;

import java.util.Date;

import com.quatspec.api.model.IBankAccount;

public class IBankAccountResource extends DefaultResource implements IBankAccount<IUserResource> {

    private String accountNumber;

    private String bankVerificationNumber;
    
    private String accountType;
    
    private String applicantId;

    private IUserResource iUser;

    public IBankAccountResource() {
        super();
    }

    public IBankAccountResource(IBankAccount bankAccount) {
        this.accountNumber = bankAccount.getAccountNumber();
        this.bankVerificationNumber = bankAccount.getBankVerificationNumber();
        this.accountType = bankAccount.getAccountType();
        if (bankAccount.getUser() != null) {
            this.iUser = new IUserResource(bankAccount.getUser());
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
    public IUserResource getUser() {
        return iUser;
    }

    @Override
    public void setUser(IUserResource iUser) {
        this.iUser = iUser;
    }

	@Override
	public int getBalanceAmount() {
		return 0;
	}

	@Override
	public void setBalanceAmount(int balanceAmount) {
		
	}

	@Override
	public Date getLastTransactionTimestamp() {		
		return null;
	}

	@Override
	public void setLastTransactionTimestamp(Date lastTransactionTimestamp) {		
		
	}

	@Override
	public Long getId() {		
		return 0L;
	}

	@Override
	public void setId(Long accountId) {
		
	}

	@Override
	public Date getCreationDate() {
		return null;
	}

	@Override
	public void setCreationDate(Date creationDate) {
		
	}

	@Override
	public String getActive() {
		return null;
	}

	@Override
	public void setActive(String active) {
		
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
		return applicantId;
	}

	@Override
	public void setApplicantId(String applicantId) {
		
	}

}
