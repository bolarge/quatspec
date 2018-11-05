package com.quatspec.service.application.service.impl;

import com.quatspec.api.model.INotitication;
import com.quatspec.persistence.domain.notification.SmsNotification;

public class SmsNotificationSender implements INotitication<SmsNotification>{

	@Override
	public SmsNotification appliesTo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void send(SmsNotification notification) {
		// TODO Auto-generated method stub
		
	}

}
