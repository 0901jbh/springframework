package com.ssafy.empapp.model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.empapp.model.dto.Dept;
import com.ssafy.empapp.util.DBUtil;

// Model : DAO(Data Access Logic)

@Repository("deptDao")
public class DeptDAOImpl implements DeptDAO {
	@Autowired
	private SqlSession session;
	
	private static final String DEPT_NS = "com.ssafy.empapp.model.dao.DeptDAO.";
	
	@Override
	public int insertDept(Dept dept){
		return session.insert(DEPT_NS+"insertDept", dept);
	}
	@Override
	public int updateDept(Dept dept){
		return session.update(DEPT_NS+"updateDept", dept);
	}	
	@Override
	public int deleteDept(int deptNo) {
		return session.delete(DEPT_NS+"deleteDept",deptNo);
	}
	@Override
	public List<Dept> selectDepts() throws SQLException {
		return session.selectList(DEPT_NS+"selectDepts");
	}
	@Override
	public Dept selectDept(int deptno) throws SQLException {
		return session.selectOne(DEPT_NS+"selectDept", deptno);
	}
	
	
		
}
