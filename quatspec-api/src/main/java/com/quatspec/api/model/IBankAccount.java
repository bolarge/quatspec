package com.quatspec.api.model;

import java.util.Date;

public interface IBankAccount<T extends IUser> {

    String getAccountNumber();

    void setAccountNumber(String accountNumber);

    String getBic();

    void setBic(String bic);

    T getUser();

    void setUser(T iUser);
    
    long getAccountId();

	void setAccountId(long accountId);

	int getBalanceAmount() ;

	void setBalanceAmount(int balanceAmount);

	Date getLastTransactionTimestamp(); 

	void setLastTransactionTimestamp(Date lastTransactionTimestamp);
        
}
