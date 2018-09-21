package com.quatspec.persistence.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.quatspec.api.enums.PaymentStatus;
import com.quatspec.api.enums.PaymentType;
import com.quatspec.api.model.IPayment;
import com.quatspec.api.model.IUser;

@Entity(name = "payment")
@Table(name = "payment")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "payment_class")
public abstract class Payment implements IPayment<User>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name="payment_id")
	private String paymentId;
	
	@Column(name = "amount")
	private BigDecimal amount;
	
	@Column(name = "payment_charge")
	private Double paymentCharge;
	
	@Column(name="payment_description")
	private String paymentDescription;
	
	@Column(name="payment_date")
	private Date paymentDate;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "payer", referencedColumnName = "id", nullable = false)
	//@Column(name = "payer")
	private User payer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payee", referencedColumnName = "id", nullable = false)
	//@Column(name = "payee")
	private User payee;
	
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
	
	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;
	
	public Payment() {}
	
	public Payment(String paymentId, BigDecimal amount, Double paymentCharge, String paymentDescription,
			Date paymentDate, User payer, User payee, PaymentStatus paymentStatus, PaymentType paymentType) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.paymentCharge = paymentCharge;
		this.paymentDescription = paymentDescription;
		this.paymentDate = paymentDate;
		this.payer = payer;
		this.payee = payee;
		this.paymentStatus = paymentStatus;
		this.paymentType = paymentType;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getPayer() {
		return payer;
	}

	public void setPayer(User iUser) {
		this.payer = iUser;
	}

	public User getPayee() {
		return payee;
	}

	public void setPayee(User iUser) {
		this.payee = iUser;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getPaymentDescription() {
		return paymentDescription;
	}

	public void setPaymentDescription(String paymentDescription) {
		this.paymentDescription = paymentDescription;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

}
