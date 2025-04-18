package com.my.dto;

import com.my.entities.Department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoEmployee {
	
	private Long id;
	
	private String name;
	
	private String surname;
	
	private DtoDepartment dtoDepartment;
}
