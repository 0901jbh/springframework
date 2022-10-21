package com.ssafy.step01.pojo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans1.xml");
		GreetingService bean = context.getBean("greeting",GreetingService.class);
		System.out.println(bean.getClass().getName());
		
		bean.sayHello("김재환");
		bean.sayGoodbye("굿바이");
	}

}
