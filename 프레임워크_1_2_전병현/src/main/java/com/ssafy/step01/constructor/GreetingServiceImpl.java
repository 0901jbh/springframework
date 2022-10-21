package com.ssafy.step01.constructor;

public class GreetingServiceImpl implements GreetingService {

	private OutputService outputter;
	
	
	
	public GreetingServiceImpl(OutputService outputter) {
		super();
		this.outputter = outputter;
	}


//	public void setOutputter(OutputService outputter) {
//		this.outputter = outputter;
//	}



	public void sayHello(String name) {
		outputter.output("Hello " + name);
		
	}

}
