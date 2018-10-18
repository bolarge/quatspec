package com.quatspec.persistence.domain.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.quatspec.persistence.domain.User;

@Entity(name = "AccountParent")
@Table(name = "bank_account")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "acc_type")
public abstract class AccountParent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected Long accountId;
	
	@Column(name = "bvn", unique = true, nullable = false)
	protected String bankVerificationNumber;

	@Column(name = "balance_amount")
	protected int balanceAmount;

	@Column(name = "last_transaction_ts")
	protected Date lastTransactionTimestamp;

    @Column(name = "account_number", unique = true, nullable = false)
    protected String accountNumber;
    
    @Column(name = "creation_date")
    protected Date creationDate;
    
    @Column(name = "active")
    protected String active;
    
    @Column(name = "account_type")
    protected String accountType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_owner", referencedColumnName = "id", nullable = false)
    protected User user;

    public AccountParent() {}

    public AccountParent(String accountNumber, String bvn, User user) {
        this.accountNumber = accountNumber;
        this.bankVerificationNumber = bvn;
        this.user = user;
    }
 
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(int balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public Date getLastTransactionTimestamp() {
		return lastTransactionTimestamp;
	}

	public void setLastTransactionTimestamp(Date lastTransactionTimestamp) {
		this.lastTransactionTimestamp = lastTransactionTimestamp;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getBankVerificationNumber() {
		return bankVerificationNumber;
	}

	public void setBankVerificationNumber(String bankVerificationNumber) {
		this.bankVerificationNumber = bankVerificationNumber;
	}
	
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}
