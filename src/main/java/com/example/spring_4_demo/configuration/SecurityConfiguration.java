package com.example.spring_4_demo.configuration;

import com.example.spring_4_demo.web.JwtAuthorizationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

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
		// https://grobmeier.solutions/spring-security-5-jwt-basic-auth.html
		// https://www.sylvainlemoine.com/2019/02/14/migrate-to-spring-security/
		http
				.addFilterBefore(new JwtAuthorizationFilter(), BasicAuthenticationFilter.class)
				.authorizeRequests(authorizeRequests ->
						authorizeRequests
								.antMatchers("/secured").authenticated()
								.anyRequest().permitAll()
				)
				.httpBasic().realmName("My org ream")
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//				.oauth2ResourceServer().jwt()
	}

/*	@Bean
	public JwtDecoder jwtDecoder() {
		return new NimbusJwtDecoder(jwtProcessor());
	}

	@Bean
	public JWTProcessor<SecurityContext> jwtProcessor() {
		return new DefaultJWTProcessor<>();
	}*/

}
