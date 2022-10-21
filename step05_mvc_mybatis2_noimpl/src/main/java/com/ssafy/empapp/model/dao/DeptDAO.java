package com.ssafy.empapp.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.empapp.model.dto.Dept;
@Repository
public interface DeptDAO {

	int insertDept(Dept dept) throws SQLException;

	List<Dept> selectDepts() throws SQLException;

	Dept selectDept(int deptno) throws SQLException;

	int updateDept(Dept dept) throws SQLException;

	int deleteDept(int deptNo) throws SQLException;

}