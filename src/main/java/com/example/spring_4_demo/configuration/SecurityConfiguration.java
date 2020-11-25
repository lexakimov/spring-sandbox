package com.example.spring_4_demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author akimov
 * created at 25.11.2020 19:18
 */
@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		super.configure(http);
		http
				.authorizeRequests()
				.antMatchers("/secured")
				.authenticated()
				.anyRequest()
				.permitAll();
	}
}
