package com.quatspec.persistence.domain.notification;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "email_notification")
public class EmailNotification extends Notification {
	
	@Column(name = "email_address", nullable = false)
	protected  String emailAddress;
	
	public EmailNotification () {
		super();
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	
}
