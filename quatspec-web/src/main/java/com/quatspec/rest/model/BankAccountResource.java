package com.quatspec.rest.model;

import java.util.Date;

import com.quatspec.api.model.IBankAccount;

public class BankAccountResource extends DefaultResource implements IBankAccount<UserResource> {

    private String accountNumber;

    private String bic;

    private UserResource appUser;

    public BankAccountResource() {
        super();
    }

    public BankAccountResource(IBankAccount bankAccount) {
        this.accountNumber = bankAccount.getAccountNumber();
        this.bic = bankAccount.getBic();
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
    public String getBic() {
        return bic;
    }

    @Override
    public void setBic(String bic) {
        this.bic = bic;
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
	public long getAccountId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setAccountId(long accountId) {
		// TODO Auto-generated method stub
		
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

}
