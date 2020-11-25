package com.example.spring_4_demo.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ResourceBundleMessageSource;


/**
 * @author akimov
 * created at 28.08.2020 20:41
 */
@Configuration
@ComponentScan("com.example.spring_4_demo.configuration")
@EnableAspectJAutoProxy
public class ApplicationConfiguration {

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasenames("labels");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setUseCodeAsDefaultMessage(true);
		messageSource.setFallbackToSystemLocale(false);
		return messageSource;
	}

	@Bean
	public MessageSourceAccessor messageSourceAccessor() {
		return new MessageSourceAccessor(messageSource());
	}

}
