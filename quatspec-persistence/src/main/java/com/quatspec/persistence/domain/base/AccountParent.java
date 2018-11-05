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
	protected Long id;
	
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
    
    @Column(name = "enabled")
	protected boolean enabled = true;
    
    @Column(name = "account_type", nullable = false)
    protected String accountType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_owner", referencedColumnName = "id", nullable = false)
    protected User user;

    public AccountParent() {}

    public AccountParent(String accountNumber, String bvn, User user) {
    	super();
        this.accountNumber = accountNumber;
        this.bankVerificationNumber = bvn;
        this.user = user;
    }
    
    public AccountParent(String bankVerificationNumber, int balanceAmount, Date lastTransactionTimestamp,
			String accountNumber, Date creationDate, String active, boolean enabled, String accountType, User user) {
		super();
		this.bankVerificationNumber = bankVerificationNumber;
		this.balanceAmount = balanceAmount;
		this.lastTransactionTimestamp = lastTransactionTimestamp;
		this.accountNumber = accountNumber;
		this.creationDate = creationDate;
		this.active = active;
		this.enabled = enabled;
		this.accountType = accountType;
		this.user = user;
	}

	public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long accountId) {
		this.id = accountId;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountParent other = (AccountParent) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		return true;
	}
	
	

}
