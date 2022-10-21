package com.ssafy.step02.pojo.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingTest {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
		GreetingService bean = context.getBean("greeting",GreetingService.class);
		System.out.println(bean.getClass().getName());
		
		bean.sayHello("김재환");
		bean.sayGoodbye("굿바이");
		bean.sayGoodbye("굿바");
		
	}

}
