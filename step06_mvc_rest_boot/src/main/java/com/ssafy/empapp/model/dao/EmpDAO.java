package com.ssafy.empapp.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.empapp.model.dto.Dept;
import com.ssafy.empapp.model.dto.Emp;

@Mapper
public interface EmpDAO {
	//void deleteEmps(Map<String, Object> map);
	void deleteEmps(int[] empNos);
	
	int insertEmp(Emp emp);
	
	List<Emp> selectEmps();
	
	Emp selectEmp(int empno);
	
	int updateEmp(Emp emp);
	
	int deleteEmp(int empno);
	
	Emp selectEmpWithDept(int empno);
	
	
}
