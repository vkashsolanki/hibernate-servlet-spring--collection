package com.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
	


	private int id;	
	private String name, email;

}
