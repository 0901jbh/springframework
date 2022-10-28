package com.ssafy.empapp.controller.exception.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestControllerAdvice
//@ControllerAdvice
public class GlobalExceptionAdvice {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
		System.out.println("exception 발생 : "+e.getMessage());
		
		log.error("exeption 발생 : " + e.getMessage(),e);
		return ResponseEntity.internalServerError().
				header("content-type", "text/plain;charset=utf-8").
				body("처리중 문제 발생 : "+e.getMessage());
	}
	
}
