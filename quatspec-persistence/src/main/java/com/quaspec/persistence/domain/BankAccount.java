
package com.quaspec.persistence.domain;

import java.util.Date;

import javax.persistence.*;

import com.quaspec.api.model.IBankAccount;

@Entity(name = "BankAccount")
@Table(name = "bank_account")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type")
public abstract class BankAccount implements IBankAccount<User> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "bvn")
	private String bankVerificationNumber;

	@Column(name = "balance_amount")
	private int balanceAmount;

	@Column(name = "last_transaction_ts")
	private Date lastTransactionTimestamp;

    @Column(name = "account_number", unique = true, nullable = false)
    private String accountNumber;
    
    @Column(name = "creation_date")
	private Date creationDate;
    
    @Column(name = "active")
	private String active;
    
    @Column(name = "account_type")
    private String accountType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_owner", referencedColumnName = "id", nullable = false)
    private User user;

    public BankAccount() {
        super();
    }

    public BankAccount(String accountNumber, User user) {
        this.accountNumber = accountNumber;
        this.user = user;
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
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

	public Long getId() {
		return id;
	}

	public void setId(long accountId) {
		this.id = accountId;
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

	@Override
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
}
