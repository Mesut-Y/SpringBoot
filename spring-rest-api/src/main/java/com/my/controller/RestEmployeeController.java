package com.my.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.my.model.Employee;
import com.my.model.UpdateEmployeeRequest;
import com.my.services.EmployeeService;

@RestController
@RequestMapping("/rest/api/employee") // requestler için kök adres belirlendi.
public class RestEmployeeController {

	@Autowired
	private EmployeeService employeeService; // @Autowired bean ulaşmasını sağlar. Olmazsa nullpointer.

	//@RequestParam annotation ile kullanmak doğrudur. Bu hali sadece örnek
	@GetMapping(path = "/list") // get isteği urlsi belirlendi. Bu url için getAllEmployeeList çalışacak.
	public List<Employee> getAllEmployeeList() { 
		return employeeService.getAllEmployeeList();
	}

	@GetMapping(path = "/list/{id}") // GetMapping isteğine id parametresini eklendi.
	public Employee getEmployeeById(@PathVariable(name = "id", required = true) String id) { // name pathteki değişken ismi ve require ile zorunlu
		return employeeService.getEmployeeById(id);
	}
	
	@GetMapping(path = "/with-params")
	public List<Employee> getEmployeeWithParams(@RequestParam(name = "firstName") String firstName, //firstName urldeki ile aynı olmalı
												@RequestParam(name = "lastName", required = false) String lastName){ //required-zorunluluk= false default true
		return employeeService.getEmployeeWithParams(firstName, lastName);
	}
	
	@PostMapping(path="/save-employee")  //Link ile sunucu veritabanına ekleme yapılır.
	public Employee saveEmployee(@RequestBody Employee newEmployee) {
		return employeeService.saveEmployee(newEmployee);
	}
	
	@DeleteMapping(path="/delete-employee/{id}")
	public boolean deleteEmployee(@PathVariable(name="id") String id) {
		return employeeService.deleteEmploye(id);
	}
	
	@PutMapping(path = "/update-employee/{id}")
	public Employee updateEmployee(@PathVariable(name = "id") String id, @RequestBody UpdateEmployeeRequest request) {
		return employeeService.updateeEmployee(id, request);
	}

}
