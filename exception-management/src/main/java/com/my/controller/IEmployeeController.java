package com.my.controller;

import java.util.List;

import com.my.dto.DtoEmployee;
import com.my.entities.RootEntitiy;

public interface IEmployeeController {
	
	public List<DtoEmployee> getAllEmployees();
	
	public RootEntitiy<DtoEmployee> getEmployeeById(Long id);
}
