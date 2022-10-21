package com.ssafy.step01.pojo;

public class GreetingServiceImpl implements GreetingService {
	@Override
	public void sayHello(String name) {
		System.out.println("Hello " + name);
	}
	@Override
	public void sayGoodbye(String name) {
		System.out.println("saygoodbye" + name);
		
	}
	

}
