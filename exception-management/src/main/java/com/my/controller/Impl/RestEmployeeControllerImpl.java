package com.my.controller.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.controller.IEmployeeController;
import com.my.dto.DtoEmployee;
import com.my.entities.RootEntitiy;
import com.my.service.IEmployeeService;

@RestController
@RequestMapping("/rest/api/employee")
public class RestEmployeeControllerImpl extends RestBaseController implements IEmployeeController {

	@Autowired
	private IEmployeeService employeeService;
	
	@GetMapping("/list")
	@Override
	public List<DtoEmployee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/list/{id}")
	@Override
	public RootEntitiy<DtoEmployee> getEmployeeById(@PathVariable(value = "id") Long id)
	{
		return ok(employeeService.getEmployeeById(id)) ;
	}
}
