package com.quatspec.service.application.service;

public interface NotificationSender<T> {

	T appliesTo();
	
	T send(T notification);
}
