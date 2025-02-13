package com.my.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.model.Employee;
import com.my.services.EmployeeService;

@RestController
@RequestMapping("/rest/api")   //requestler için kök adres belirlendi.
public class RestEmployeeController {
	
	@Autowired  
	private EmployeeService employeeService;  //@Autowired bean ulaşmasını sağlar. Olmazsa nullpointer.
	
	@GetMapping(path = "/employee-list")  //get isteği urlsi belirlendi. Bu url için getAllEmployeeList çalışacak.
	public List<Employee> getAllEmployeeList(){
		return employeeService.getAllEmployeeList();
	}
}
