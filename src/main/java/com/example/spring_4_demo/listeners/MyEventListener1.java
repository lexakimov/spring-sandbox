package com.example.spring_4_demo.listeners;

import com.example.spring_4_demo.aspects.Loggable;
import org.springframework.context.ApplicationListener;

/**
 * @author akimov
 * created at 21.11.2020 16:35
 */
public interface MyEventListener1 extends ApplicationListener<MyEvent> {
	@Loggable
	void onApplicationEvent(MyEvent event);

	@Loggable
	void internalMethod();
}
