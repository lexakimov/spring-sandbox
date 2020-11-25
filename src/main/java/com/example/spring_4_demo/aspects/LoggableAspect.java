package com.example.spring_4_demo.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author akimov
 * created at 15.11.2020 10:04
 */
@Slf4j
@Aspect
@Component
public class LoggableAspect {

	@Around("@annotation(Loggable)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		log.debug("method {} : start", joinPoint.getSignature().toShortString());
		Object proceed = joinPoint.proceed();
		log.debug("method {} : done", joinPoint.getSignature().toShortString());
		return proceed;
	}

}
