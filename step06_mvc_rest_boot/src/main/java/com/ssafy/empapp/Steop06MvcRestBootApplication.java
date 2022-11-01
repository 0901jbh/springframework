package com.ssafy.empapp;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(basePackages="com.ssafy.empapp.model.dao",annotationClass = Mapper.class )
@SpringBootApplication
public class Steop06MvcRestBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Steop06MvcRestBootApplication.class, args);
	}

}
