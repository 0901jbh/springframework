package com.ssafy.empapp.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
//@RequiredArgsConstructor
//@EqualsAndHashCode
//@ToString
//@Setter
//@Getter
//Model : DTO, DO, VO

//@NoArgsConstructor
//@AllArgsConstructor

//@NoArgsConstructor
//@RequiredArgsConstructor
//@AllArgsConstructor
@NoArgsConstructor
@Data
@RequiredArgsConstructor
public class Dept {
	@NonNull
	private int deptno;
	@NonNull
	private String dname;
	@NonNull
	private String loc;
	private List<Emp> emps;
//	
//	public Dept() {
//		
//	}
//	public Dept(int deptno,String dname,String loc) {
//		this.deptno = deptno;
//		this.dname= dname;
//		this.loc= loc;
//	}
}
