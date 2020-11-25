package com.example.spring_4_demo.listeners;

import org.springframework.context.ApplicationEvent;

/**
 * @author akimov
 * created at 27.08.2020 21:22
 */
public class MyEvent extends ApplicationEvent {

	private final String message;

	public MyEvent(Object source, String message) {
		super(source);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
