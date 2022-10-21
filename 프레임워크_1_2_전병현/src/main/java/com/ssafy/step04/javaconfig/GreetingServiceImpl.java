package com.ssafy.step04.javaconfig;



public class GreetingServiceImpl implements GreetingService {
	
	private OutputService outputter;
	
	public GreetingServiceImpl() {
		System.out.println("OutputService outputter");
	}
	
	public void setOutputter(OutputService outputter) {
		this.outputter = outputter;
	}



	public void sayHello(String name) {
		outputter.output("Hello " + name);
		
	}

}
