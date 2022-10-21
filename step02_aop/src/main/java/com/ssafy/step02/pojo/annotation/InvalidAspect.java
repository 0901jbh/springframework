package com.ssafy.step02.pojo.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Aspect
@Component
@Order(2)
public class InvalidAspect {
	
	@Around("execution(void com.ssafy.step02..GreetingService.sayGoodbye(*))")
	public Object Check(ProceedingJoinPoint joinPoint) throws Throwable {
		
		String name = (String) joinPoint.getArgs()[0];
		if(name.length() >=3)
			return joinPoint.proceed();
		else {
			throw new IllegalArgumentException();
		}
		
	}
}
