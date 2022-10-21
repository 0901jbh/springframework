package com.ssafy.step04.javaconfig2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GreetingTest {

	public static void main(String[] args) {
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GreetingConfiguration.class);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.ssafy.step04.javaconfig2");
		
		GreetingService bean = context.getBean("greeting",GreetingService.class);
		bean.sayHello("김재환");
	}

}
