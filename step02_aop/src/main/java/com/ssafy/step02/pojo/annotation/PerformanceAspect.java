package com.ssafy.step02.pojo.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Order(1)
@Aspect
@Component
public class PerformanceAspect {
	@Around(value="execution(* *(..))")
	public Object timeCheck(ProceedingJoinPoint joinPoint) {
		Signature s = joinPoint.getSignature();
		System.out.println("\t"+s.getName()+"'s time check start..");
		long start = System.nanoTime();
		Object o = null;;
		try {
			o = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		long end = System.nanoTime();
		System.out.println(s.getName()+"'s processing time is "+(end-start)+"ns");
		return o;
	}
}
