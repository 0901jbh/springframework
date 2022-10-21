package com.ssafy.empapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.empapp.model.dao.DeptDAO;
import com.ssafy.empapp.model.dto.Dept;

// Model : B/L

@Service
public class DeptServiceImpl implements DeptService {

	private DeptDAO deptDao;
	
	
	@Autowired
	public DeptServiceImpl(DeptDAO deptDao) {
		super();
		this.deptDao = deptDao;
	}
	@Override
	public boolean registerDept(Dept dept) throws Exception  {
		// 遺��꽌 �벑濡�
		return deptDao.insertDept(dept) > 0;
	}
	@Override
	public List<Dept> getDepts() throws Exception {
		// 遺��꽌由ъ뒪�듃 議고쉶
		return deptDao.selectDepts();
	}
	@Override
	public Dept getDept(int deptno) throws Exception {
		// 遺��꽌議고쉶
		return deptDao.selectDept(deptno) ;
	}
	@Override
	public boolean modifyDept(Dept dept) throws Exception {
		// 遺��꽌 �닔�젙
		return deptDao.updateDept(dept) > 0;
	}
	@Override
	public boolean deleteDept(int deptno)throws Exception  {
		// 遺��꽌 �궘�젣
		return deptDao.deleteDept(deptno) > 0;
	}
	
}










