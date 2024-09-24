package com.study.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor

public class Student {
	
	private int id;
	private String name,email,mobile,password;
	
	
	

}
