package com.ssafy.empapp.model.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.empapp.model.dao.DeptDAO;
import com.ssafy.empapp.model.dto.Dept;

import lombok.extern.slf4j.Slf4j;

// Model : B/L
@Slf4j()
@Service
public class DeptServiceImpl implements DeptService {

	private DeptDAO deptDao;
	
	@Autowired
	public DeptServiceImpl(DeptDAO deptDao) {
		super();
		this.deptDao = deptDao;
	}
	@Override
	public boolean registerDept(Dept dept){
		// 遺��꽌 �벑濡�
		return deptDao.insertDept(dept) > 0;
	}
	@Override
	public List<Dept> getDepts(){
		// 遺��꽌由ъ뒪�듃 議고쉶
		System.out.println("부서리스트 조회");
		log.info("부서리스트 조회");
		return deptDao.selectDepts();
	}
	@Override
	public Dept getDept(int deptno){
		// 遺��꽌議고쉶
		return deptDao.selectDept(deptno) ;
	}
	@Override
	public boolean modifyDept(Dept dept){
		// 遺��꽌 �닔�젙
		return deptDao.updateDept(dept) > 0;
	}
	@Override
	public boolean deleteDept(int deptno)  {
		// 遺��꽌 �궘�젣
		return deptDao.deleteDept(deptno) > 0;
	}
	@Override
	public Dept getDeptWithEmps(int deptno) {
		return deptDao.selectDeptWithEmps(deptno);
	}
	@Override
	public List<Dept> getConditionList(Map<String, Object> map) {
		return deptDao.getConditionList(map);
		
	}
	
}










