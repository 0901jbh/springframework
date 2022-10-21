package com.ssafy.step04.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GreetingTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);
		GreetingService bean = context.getBean("greeting",GreetingService.class);
		bean.sayHello("김재환");
	}

}
