package com.quatspec.api.model;

import java.util.Date;

public interface IBankAccount<T extends IUser> {

    String getAccountNumber();

    void setAccountNumber(String accountNumber);

    T getUser();

    void setUser(T iUser);
    
    Long getId();

	void setId(long accountId);

	int getBalanceAmount() ;

	void setBalanceAmount(int balanceAmount);

	Date getLastTransactionTimestamp(); 

	void setLastTransactionTimestamp(Date lastTransactionTimestamp);
	
	Date getCreationDate();

	void setCreationDate(Date creationDate);
	
	String getActive();

	void setActive(String active);
	
	String getBankVerificationNumber() ;

	void setBankVerificationNumber(String bankVerificationNumber);
        
}
