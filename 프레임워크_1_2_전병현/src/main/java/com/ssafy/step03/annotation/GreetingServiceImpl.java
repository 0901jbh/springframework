package com.ssafy.step03.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("greeting")    //class주고 bean 등록
public class GreetingServiceImpl implements GreetingService {
	
	
	@Qualifier("outputterFile")
	//@Autowired //reflection api로 제어 가능   
	private OutputService outputter;
	
	
	
	
	@Autowired //매개변수 이름이 있어서 qualifier를 따로 쓰지 않는다
	public GreetingServiceImpl(OutputService outputter) {
		super();
		System.out.println("OutputService outputter");
		this.outputter = outputter;
	}



//	public GreetingServiceImpl() {
//		System.out.println("con");
//	}
//	@Qualifier("outputterFile")
//	@Autowired
	public void setOutputter(OutputService outputter) {
		this.outputter = outputter;
	}



	public void sayHello(String name) {
		outputter.output("Hello " + name);
		
	}

}
