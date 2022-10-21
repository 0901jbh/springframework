package com.ssafy.step02.pojo.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Order(3)
@Aspect
@Component
public class LogAspect {
	
	@Pointcut("execution(void com.ssafy.step01..GreetingService.*Hello(*))")
	public void sayPointcut() {}
	
	
	@Before("sayPointcut()")    //("")
	public void beforeLogging(JoinPoint joinPoint) {
		System.out.println("메소드 호출 전,..."+joinPoint.getSignature()+" "+joinPoint.getArgs()[0]);
	}
}
