package com.ssafy.empapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.empapp.model.dto.User;
import com.ssafy.empapp.model.service.UserService;
@Controller
@RequestMapping("/user")
public class UserController{
	@Autowired
	private UserService userService;

	@PostMapping("/regist.do")
	protected String regist(String userid,String password,String name,String email) throws Exception{
		User user = new User(userid,password,name,email);
		boolean res = userService.regist(user);
		
		
		
		return "/user/login";
	}
	
	
	
	@PostMapping("/login.do")
	protected String login(String userId,String password,HttpSession session,Model model) throws Exception {
		

		String name = userService.login(userId, password);
		
		if(name != null) {
			session.setAttribute("userId", userId);
			session.setAttribute("userName", name);
			return "redirect:/index.do";
		}else {		
			model.addAttribute("errorMsg", "아이디나 비밀번호가 일치하지 않습니다.");
			return "/user/login";
		}
		
	}
	@GetMapping("/logout.do")
	protected String logout(HttpSession session) throws Exception {

		session.invalidate();
		return "redirect:/index.do";
	}
	
}
