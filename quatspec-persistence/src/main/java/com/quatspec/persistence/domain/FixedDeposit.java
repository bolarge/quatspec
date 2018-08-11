package com.quatspec.persistence.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "FixedDeposit")
@Table(name = "fixed_deposit")
public class FixedDeposit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "fixed_deposit_id", unique = true)
	private String fixedDepositId;

	@ManyToOne
	@JoinColumn(name = "account_id", referencedColumnName = "account_id", nullable = false)
	private BankAccount bankAccountId;

	@Column(name = "fd_creation_date")
	private Date fdCreationDate;

	@Column(name = "amount")
	private int fdAmount;

	@Column(name = "tenure")
	private int tenure;

	@Column(name = "active")
	private String active;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setFixedDepositId(String fixedDepositId) {
		this.fixedDepositId = fixedDepositId;
	}

	public String getFixedDepositId() {
		return fixedDepositId;
	}

	public Date getFdCreationDate() {
		return fdCreationDate;
	}

	public void setFdCreationDate(Date fdCreationDate) {
		this.fdCreationDate = fdCreationDate;
	}

	public int getFdAmount() {
		return fdAmount;
	}

	public void setFdAmount(int fdAmount) {
		this.fdAmount = fdAmount;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public BankAccount getBankAccountId() {
		return bankAccountId;
	}

	public void setBankAccountId(BankAccount bankAccountId) {
		this.bankAccountId = bankAccountId;
	}

	@Override
	public String toString() {
		return "FixedDepositDetails [fixedDepositId=" + fixedDepositId
				+ ", bankAccountId=" + bankAccountId + ", fdCreationDate="
				+ fdCreationDate + ", fdAmount=" + fdAmount + ", tenure="
				+ tenure + ", active=" + active + "]";
	}

	@Override
	public boolean equals(Object obj) {
		FixedDeposit other = (FixedDeposit) obj;
		if (other.getFixedDepositId() == this.fixedDepositId) {
			return true;
		} else {
			return false;
		}
	}
}