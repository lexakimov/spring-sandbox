package com.example.spring_4_demo.web.controllers.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

/**
 * @author akimov
 * created at 28.11.2020 10:11
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

	@ResponseBody
	@ExceptionHandler(HttpClientErrorException.Unauthorized.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	String employeeNotFoundHandler(HttpClientErrorException.Unauthorized ex) {
		return ex.getMessage();
	}
}
