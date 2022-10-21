package com.ssafy.step04.javaconfig2;

import org.springframework.stereotype.Component;

public class OutputServiceImplConsole implements OutputService {

	public void output(String msg) {
		System.out.println(msg);

	}

}
