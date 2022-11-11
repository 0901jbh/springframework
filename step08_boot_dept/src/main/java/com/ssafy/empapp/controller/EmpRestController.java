package com.ssafy.empapp.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.InternalResourceView;

import com.ssafy.empapp.model.dto.Emp;
import com.ssafy.empapp.model.service.EmpService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api/emps")
@RestController
@Slf4j
public class EmpRestController {
	
	@Autowired
	private EmpService empService;
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteEmps(@RequestBody int[] empno) {
		log.info("deleteEmps ....");
		if(empno != null) {
			empService.deleteEmps(empno);
			return ResponseEntity.ok(empno);
		} else
			return ResponseEntity.noContent().build();

	}
		
	@GetMapping()
	protected ResponseEntity<List<Emp>> getEmpList(){
		return ResponseEntity.ok().body(empService.selectEmps());
	}
	
	@PostMapping()
	protected ResponseEntity<Emp> register(@RequestBody Emp emp){
		boolean res = empService.insertEmp(emp);
		
		if(res) {
			return ResponseEntity.created(URI.create("/api/emps/"+emp.getEmpno())).build();
		}else {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@GetMapping("/{empno}")
	protected ResponseEntity<?> getDeptDetailWithEmps(@PathVariable int empno){
		Emp emp2 = empService.selectEmp(empno);
		if(emp2 != null) {
			
				return ResponseEntity.ok(emp2);
			
			
		} else {
			return ResponseEntity.noContent().build();
		}
		
	}
	
	
	@PutMapping("/{empno}")
	protected ResponseEntity<?> modify(@RequestBody Emp emp) {
		
		Emp emp2 = empService.selectEmp(emp.getEmpno());
		if(emp2 != null) {
			boolean res = empService.updateEmp(emp);
			if(res) {
				return ResponseEntity.ok(emp);
			} else {
				return ResponseEntity.internalServerError().build();
			}
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{empno}")
	protected ResponseEntity<?> remove(@PathVariable int empno) {
		Emp emp2 = empService.selectEmp(empno);
		if(emp2 != null) {
			boolean res = empService.deleteEmp(empno);
			if(res) {
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.internalServerError().build();
			}
		} else {
			return ResponseEntity.notFound().build();
		}
		
		
		
		
	}
}
