package com.ssafy.empapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping({"/index.do","/"})
	protected String index() throws Exception {
		return "index"; //views 밑에 index가 있어야한다
	}
	
	

}
