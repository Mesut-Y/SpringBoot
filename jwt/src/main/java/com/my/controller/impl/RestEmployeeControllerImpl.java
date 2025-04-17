package com.my.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.controller.IRestEmployeeController;
import com.my.dto.DtoEmployee;
import com.my.service.impl.EmployeeServiceImpl;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

@RestController
@RequestMapping("/employee")
public class RestEmployeeControllerImpl implements IRestEmployeeController{

	@Autowired
	public EmployeeServiceImpl employeeService;
	
	@Override
	@GetMapping("/{id}")
	public DtoEmployee findEmployeeById(@Valid @NotEmpty @PathVariable(value= "id") Long id) {
		return employeeService.findEmployeeById(id);
	}

	
}
