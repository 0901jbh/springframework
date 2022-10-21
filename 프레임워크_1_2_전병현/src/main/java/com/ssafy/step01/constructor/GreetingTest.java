package com.ssafy.step01.constructor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans1.xml");
		GreetingService bean = context.getBean("greeting",GreetingService.class);
		bean.sayHello("김재환");
	}

}
