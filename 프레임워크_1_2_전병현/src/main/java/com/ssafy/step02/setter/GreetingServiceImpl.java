package com.ssafy.step02.setter;

public class GreetingServiceImpl implements GreetingService {

	private OutputService outputter;
	
	
	
	public GreetingServiceImpl() {
		System.out.println("con");
	}


	public void setOutputter(OutputService outputter) {
		this.outputter = outputter;
	}



	public void sayHello(String name) {
		outputter.output("Hello " + name);
		
	}

}
