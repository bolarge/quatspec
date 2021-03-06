package com.quatspec.persistence.domain.notification;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sms_notification")
public class SmsNotification extends Notification{

	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;
	
	public SmsNotification() {
		super();
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
