package com.example.spring_4_demo.services.impl;

import com.example.spring_4_demo.aspects.Loggable;
import com.example.spring_4_demo.services.MyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author akimov
 * created at 21.11.2020 16:37
 */
@Slf4j
@Service
public class MyServiceImpl implements MyService {

	@Autowired
	private MyService self;

	@Resource(type = MyService.class)
	private MyService self2;

	@Override
	@Loggable
	public void doAction() {
		log.info("service do some action...");
		self.doAnotherAction();
	}

	@Override
	@Loggable
	public void doAnotherAction() {
		log.info("service do another action...");
		self2.doAnotherAction2();
	}

	@Override
	@Loggable
	public void doAnotherAction2() {
		log.info("service do another action 2...");
	}

}
