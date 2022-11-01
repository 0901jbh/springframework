package com.ssafy.empapp.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.InternalResourceView;

import com.ssafy.empapp.model.dto.Dept;
import com.ssafy.empapp.model.service.DeptService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequestMapping("/api/depts")
@RestController
public class DeptRestController  {

	@Autowired
	private DeptService deptService;
	
	
	@GetMapping()
	protected ResponseEntity<List<Dept>> getDeptList(@RequestParam(required=false)String dname,
			@RequestParam(required = false) String loc) {
		log.info("getDeptList with  now params...");
		//return new ResponseEntity<List<Dept>>(deptService.getDepts(null),HttpStatus.OK);
		
		HashMap<String,Object> conditions = new HashMap<>();
		if(dname != null) conditions.put("dname", dname);
		if(loc != null) conditions.put("loc", loc);
		
		
		//return ResponseEntity.ok(deptService.getDepts(null)); 
		return ResponseEntity.ok().body(deptService.getDepts(conditions)); 
		
	}
	@GetMapping("/{deptno}")
	protected ResponseEntity<Dept> getDeptDetail(@PathVariable int deptno) {
		Dept dept = deptService.getDept(deptno);
		if(dept != null) {
			//return new ResponseEntity<Dept>(dept, HttpStatus.OK);
			return ResponseEntity.ok(dept);
		} else {
			//return new ResponseEntity<Dept>(dept,HttpStatus.NOT_FOUND);
			return ResponseEntity.notFound().build();
		}
			
		
	}
	
	@PostMapping
	protected ResponseEntity<Dept> register(@RequestBody Dept dept){
		
		boolean res = deptService.registerDept(dept);
		
		// 4. view page by result
		if(res) {
			return ResponseEntity.created(URI.create("/api/depts/"+dept.getDeptno())).build();
		}else {			
			return ResponseEntity.internalServerError().build();
		}
	}
	
	
	@PutMapping("/{deptno}")
	protected ResponseEntity<?> modify(@RequestBody Dept dept){
		Dept dept2 = deptService.getDept(dept.getDeptno());
		if(dept2 != null) {
			boolean res = deptService.modifyDept(dept);
			if(res) {
				return ResponseEntity.ok(dept);
			} else {
				return ResponseEntity.internalServerError().build();
			}
		}  else {
			return ResponseEntity.notFound().build();
		}
		
		
	}
	
	@DeleteMapping("/{deptno}")
	protected ResponseEntity<?> remove(@PathVariable int deptno){
		Dept dept2 = deptService.getDept(deptno);
		if(dept2 != null) {
			boolean res = deptService.deleteDept(deptno);
			if(res) {
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.internalServerError().build();
			}
		}  else {
			return ResponseEntity.notFound().build();
		}
		
		
	}

	//검색 조건
	/*
	@GetMapping(params = {"dname","loc"})
	protected ResponseEntity<List<Dept>> getDeptListByCondition(@RequestParam Map<String,Object> condition) {
		log.info("getDeptlist with params...");
		List<Dept> depts = deptService.getDepts(condition);
		return ResponseEntity.ok(depts);
	}	
	
	@RequestMapping("/rest/list.do")
	@ResponseBody
	protected List<Dept> getDeptRestList() throws Exception {
		
		return deptService.getDepts(null);
	}
	*/
	
	@GetMapping("/{deptno}/emps")
	protected ResponseEntity<?> getDeptDetailWithEmps(@PathVariable int deptno){
		
		Dept dept = deptService.getDeptWithEmps(deptno);
		if(dept != null) {
			//return new ResponseEntity<Dept>(dept, HttpStatus.OK);
			return ResponseEntity.ok(dept);
		} else {
			//return new ResponseEntity<Dept>(dept,HttpStatus.NOT_FOUND);
			return ResponseEntity.notFound().build();
		}
	}

	
	
	
	
	
}
