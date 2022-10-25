package com.ssafy.empapp.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ssafy.empapp.model.dto.Dept;
@Repository
public interface DeptDAO {

	int insertDept(Dept dept);

	List<Dept> selectDepts();

	Dept selectDept(int deptno);

	int updateDept(Dept dept);

	int deleteDept(int deptNo);
	
	Dept selectDeptWithEmps(int deptno);

	List<Dept> getConditionList(Map<String,Object> map);
	
}