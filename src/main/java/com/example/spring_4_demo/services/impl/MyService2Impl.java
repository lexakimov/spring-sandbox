package com.example.spring_4_demo.services.impl;

import com.example.spring_4_demo.aspects.Loggable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author akimov
 * created at 21.11.2020 16:37
 */
@Slf4j
@Service
public class MyService2Impl {

	@Autowired
	private MyService2Impl self;

	@Loggable
	public void doAction() {
		log.info("service do some action...");
		self.doAnotherAction();
	}

	@Loggable
	public void doAnotherAction() {
		log.info("service do another action...");
		self.doAnotherAction2();
	}

	@Loggable
	private void doAnotherAction2() {
		log.info("service do another action 2...");
		self.doAnotherAction3();
	}

	@Loggable
	private void doAnotherAction3() {
		log.info("service do another action 3...");
	}

}
