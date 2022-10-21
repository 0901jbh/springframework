package com.ssafy.step04.javaconfig2;

import org.springframework.beans.factory.annotation.Autowired;

public class GreetingServiceImpl implements GreetingService {
	
	private OutputService outputter;
	
	public GreetingServiceImpl() {
		System.out.println("OutputService outputter3");
	}
	@Autowired
	public void setOutputter(OutputService outputter) {
		this.outputter = outputter;
	}



	public void sayHello(String name) {
		outputter.output("Hello " + name);
		
	}

}
