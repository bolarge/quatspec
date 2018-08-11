package com.quatspec.persistence.domain;

import java.util.Date;

import javax.persistence.*;

import com.quatspec.api.model.IBankAccount;

@Entity(name = "BankAccount")
@Table(name = "bank_account")
public class BankAccount implements IBankAccount<User> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long accountId;

	@Column(name = "balance_amount")
	private int balanceAmount;

	@Column(name = "last_transaction_ts")
	private Date lastTransactionTimestamp;

    @Column(name = "account_number", unique = true)
    private String accountNumber;

    @Column(name = "bic")
    private String bic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_name")
    private User user;

    public BankAccount() {
        super();
    }

    public BankAccount(String accountNumber, String bic, User user) {
        this.accountNumber = accountNumber;
        this.bic = bic;
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
    public String getBic() {
        return bic;
    }

    @Override
    public void setBic(String bic) {
        this.bic = bic;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
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
    
    

	
}
