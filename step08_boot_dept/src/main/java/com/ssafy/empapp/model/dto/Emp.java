package com.ssafy.empapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Builder
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
	
	@NonNull
	private int empno;
	@NonNull
	private String ename;
	@NonNull
	private String job;
	
	private int mgr;
	private String hiredate;
	@NonNull
	private double sal;
	private double comm;	
	@NonNull
	private int	deptno;
	
	private Dept dept;
	
	
	
	
}
