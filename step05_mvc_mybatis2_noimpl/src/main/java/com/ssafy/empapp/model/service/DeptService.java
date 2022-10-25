package com.ssafy.empapp.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.empapp.model.dto.Dept;

public interface DeptService {

	boolean registerDept(Dept dept);

	List<Dept> getDepts();

	Dept getDept(int deptno);

	boolean modifyDept(Dept dept);

	boolean deleteDept(int deptno);
	
	Dept getDeptWithEmps(int deptno);

	List<Dept> getConditionList(Map<String, Object> map);

}