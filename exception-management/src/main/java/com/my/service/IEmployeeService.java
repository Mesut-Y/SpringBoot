package com.my.service;

import java.util.List;

import com.my.dto.DtoEmployee;

public interface IEmployeeService {

	public List<DtoEmployee> getAllEmployees();
	
	public DtoEmployee getEmployeeById(Long id);
	
}
