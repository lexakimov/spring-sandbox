package com.example.spring_4_demo.listeners;

import com.example.spring_4_demo.aspects.Loggable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author akimov
 * created at 27.08.2020 21:22
 */
@Slf4j
@Component("someListener")
public class MyEventListener1Impl implements MyEventListener1 {

	@Autowired
	private MyEventListener1 thisBean;

	@Override
	@Loggable
	public void onApplicationEvent(MyEvent event) {
		log.info("received: " + event.getMessage() + " from " + event.getSource());
		thisBean.internalMethod();
	}

	@Override
	@Loggable
	public void internalMethod() {
		log.info("Internal");
	}


}
