package com.my.controller;

import java.util.List;

import com.my.dto.DtoEmployee;

public interface IEmployeeController {
	
	public List<DtoEmployee> getAllEmployees();
	
	public DtoEmployee getEmployeeById(Long id);
}
