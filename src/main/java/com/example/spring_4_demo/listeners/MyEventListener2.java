package com.example.spring_4_demo.listeners;

import com.example.spring_4_demo.aspects.Loggable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;

/**
 * @author akimov
 * created at 27.08.2020 21:22
 */
@Slf4j
//@Component
public class MyEventListener2 {

	@EventListener
	@Loggable
	public void onApplicationEvent(MyEvent event) {
		log.info("received: " + event.getMessage() + " from " + event.getSource());
	}

}
