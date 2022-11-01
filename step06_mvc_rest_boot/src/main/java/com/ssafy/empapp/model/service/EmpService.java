package com.ssafy.empapp.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.empapp.model.dto.Emp;

public interface EmpService {
	void deleteEmps(int[] empNos);

	boolean insertEmp(Emp emp);
	
	List<Emp> selectEmps();
	
	Emp selectEmp(int empno);
	
	boolean updateEmp(Emp emp);
	
	boolean deleteEmp(int empno);
	
	Emp selectEmpWithDept(int empno);
	

	
}
