package com.example.spring_4_demo;

import com.example.spring_4_demo.configuration.ApplicationConfiguration;
import com.example.spring_4_demo.services.MyService;
import com.example.spring_4_demo.services.impl.MyService2Impl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author akimov
 * created at 24.08.2020 15:23
 */
@Slf4j
public class Main {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		ctx.registerShutdownHook();

		MyService bean = ctx.getBean(MyService.class);
		bean.doAction();

		MyService2Impl bean2 = ctx.getBean(MyService2Impl.class);
		bean2.doAction();
	}
}

