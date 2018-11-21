package com.quatspec.api.model;

import java.util.Date;

public interface IBankAccount<T extends IUser> {
	
    T getUser();

    void setUser(T iUser);
	
	String getApplicantId();
	
	void setApplicantId(String applicantId);

    String getAccountNumber();

    void setAccountNumber(String accountNumber);
    
    Long getId();

	void setId(Long accountId);

	double getBalanceAmount() ;

	void setBalanceAmount(double balanceAmount);

	Date getLastTransactionTimestamp(); 

	void setLastTransactionTimestamp(Date lastTransactionTimestamp);
	
	Date getCreationDate();

	void setCreationDate(Date creationDate);
	
	String getActive();

	void setActive(String active);
	
	String getBankVerificationNumber() ;

	void setBankVerificationNumber(String bankVerificationNumber);
	
	String getAccountType();
	
	void setAccountType(String accountType);
        
}
