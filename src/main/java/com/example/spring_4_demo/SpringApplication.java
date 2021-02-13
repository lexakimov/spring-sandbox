package com.example.spring_4_demo;

import com.example.spring_4_demo.configuration.AppConfiguration;
import com.example.spring_4_demo.services.MyService;
import com.example.spring_4_demo.services.impl.MyServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author akimov
 * created at 24.08.2020 15:23
 */
@Slf4j
public class SpringApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);
		ctx.registerShutdownHook();

		MyService bean = ctx.getBean(MyServiceImpl.class);
		bean.doAction();
	}
}

