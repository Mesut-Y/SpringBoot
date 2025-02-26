package com.my.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.controller.IEmployeeController;
import com.my.dto.DtoEmployee;
import com.my.services.IEmployeeService;

@RestController
@RequestMapping("/rest/api")
public class EmployeeController implements IEmployeeController {

	@Autowired
	private IEmployeeService employeeService;
	
	@Override
	@GetMapping(path = "/list/employee")
	public List<DtoEmployee> findAllEmployees() {	
		return employeeService.findAllEmployees();
	}

	
}
