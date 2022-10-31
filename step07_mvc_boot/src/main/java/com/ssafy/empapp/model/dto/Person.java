package com.ssafy.empapp.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class Person {

	@NonNull
	private String name;
	@NonNull
	private int age;
}
