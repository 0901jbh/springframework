package com.ssafy.empapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.InternalResourceView;

import com.ssafy.empapp.model.dto.Dept;
import com.ssafy.empapp.model.service.DeptService;


@RequestMapping("/dept")
@Controller
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	
	
	
	
	@RequestMapping("/rest/list.do")
	@ResponseBody
	protected List<Dept> getDeptRestList() throws Exception {
		
		return deptService.getDepts();
	}
	@RequestMapping("/detail.do")
	protected ModelAndView getDeptDetail(@RequestParam int deptno) throws Exception {

		
		Dept dept = deptService.getDept(deptno);
		ModelAndView mav = new ModelAndView();
		mav.addObject("dept",dept); // request.setAttribute("dept", dept);
		mav.setViewName("dept/detail_form");
		
		return mav;
	}
	
	@RequestMapping("/detail_with_emps.do")
	protected ModelAndView getDeptDetailWithEmps(@RequestParam int deptno) throws Exception {

		
		Dept dept = deptService.getDeptWithEmps(deptno);
		ModelAndView mav = new ModelAndView();
		mav.addObject("dept",dept); // request.setAttribute("dept", dept);
		mav.setViewName("dept/detail_form_emps");
		
		return mav;
	}
	
	
	@RequestMapping(value="/register.do", method= RequestMethod.POST)
	protected String register(@RequestParam  int deptno, String dname, String loc,Model model) throws Exception {
		boolean res = deptService.registerDept(new Dept(deptno, dname, loc));
		
		// 4. view page by result
		if(res) {
			return "redirect:/dept/list.do";
		}else {
			model.addAttribute("errorMsg","????????? ?????????????????????");
			return "dept/register_form";
		}
	}
//	@PostMapping("/modify.do")
//	protected ModelAndView modify(Dept dept) throws Exception {
//		
//		// 2. call Model(Service)
//		boolean res = deptService.modifyDept(dept);
//		ModelAndView mav = new ModelAndView();
//		// 3. move page by result
//		if(res) {
//			mav.addObject("msg", "?????? ????????? ?????????????????????.");
//		}else {
//			mav.addObject("msg", "?????? ????????? ?????????????????????.");			
//		}
//		
//		mav.setView(new InternalResourceView("/dept/list.do"));
//		return mav;
//	}
	
	@GetMapping("/remove.do")
	protected ModelAndView remove(int deptno) throws Exception {
		
		boolean res = deptService.deleteDept(deptno);
		ModelAndView mav = new ModelAndView();
		if(res) {
			mav.addObject("msg", "?????? ????????? ?????????????????????.");
		}else {
			mav.addObject("msg", "?????? ????????? ?????????????????????.");			
		}
		mav.setView(new InternalResourceView("/dept/list.do"));
		return mav;
	}
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e,Model model) {
		System.out.println("exception ??????"+e.getMessage());
		model.addAttribute("errorMsg",e.getMessage());
		return "error";
	}
	@PostMapping("/modify.do")
	protected String modify(Dept dept,RedirectAttributes rAttributes) throws Exception {
		
		// 2. call Model(Service)
		boolean res = deptService.modifyDept(dept);
		// 3. move page by result
		if(res) {
//			rAttributes.addAttribute("msg", "?????? ????????? ?????????????????????.");
			rAttributes.addFlashAttribute("msg", "?????? ????????? ?????????????????????.");
		}else {
			rAttributes.addFlashAttribute("msg", "?????? ????????? ?????????????????????.");
		}
		
		return "redirect:/dept/list.do";
	}
	@RequestMapping("/list.do")
	protected String getDeptList(Model model) throws Exception {

		List<Dept> depts = deptService.getDepts();
		model.addAttribute("deptList", depts); //request ???????????? ??????
		
		return "dept/list";
	}
	@PostMapping("/search.do")
	protected String getConditionList(String dname,String loc,Model model) throws Exception {
		System.out.println("in");
		System.out.println(dname+","+loc+"|");
		if(loc == null)
		System.out.println("nullllllllll");
		Map<String, Object> map = new HashMap<String,Object>();
		if(dname != null && !dname.equals(""))
		map.put("dname",dname);
		if(loc != null && !loc.equals(""))
		map.put("loc",loc);
		List<Dept> depts = deptService.getConditionList(map);
		System.out.println("depts size : "+ depts.size());
		model.addAttribute("deptList",depts);
		return "dept/list";
	}
	
	
}
