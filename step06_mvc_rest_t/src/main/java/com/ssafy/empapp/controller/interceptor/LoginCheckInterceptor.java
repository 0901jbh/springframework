package com.ssafy.empapp.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheckInterceptor implements HandlerInterceptor {
	//선택적 재정의 controller가 불리기 전 login체킹만하면댐 이거 pojo아님
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		if(userId == null) {
			System.out.println("로그인 안된 상태");
			response.sendRedirect(request.getContextPath()+"/user/login_form.do");
			
			return false;
			//false로주면 체이닝 안탐
		}
		return true;
	}
	

		
}