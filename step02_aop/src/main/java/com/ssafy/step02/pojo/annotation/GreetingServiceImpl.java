package com.ssafy.step02.pojo.annotation;

import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service("greeting")
public class GreetingServiceImpl implements GreetingService {
	@Override
	public void sayHello(String name) {
		System.out.println("Hello " + name);
	}
	@Override
	public void sayGoodbye(String name) throws Exception{
		
		System.out.println("saygoodbye" + name);
		
	}
	
	
}
