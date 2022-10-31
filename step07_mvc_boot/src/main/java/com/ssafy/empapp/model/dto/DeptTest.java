package com.ssafy.empapp.model.dto;

public class DeptTest {

	public static void main(String[] args) {
		Dept e = new Dept(0,"개발1팀","서울");
		System.out.println(e);
		e.setDname(null);
		System.out.println(e);
	}

}
