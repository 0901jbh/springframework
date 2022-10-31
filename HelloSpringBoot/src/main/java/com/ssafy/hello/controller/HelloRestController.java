package com.ssafy.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HelloRestController {
	@GetMapping("/resthello")
	public String hello() {
		return "hello rest controller!!";
	}
}
