package com.my.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.model.Employee;
import com.my.model.UpdateEmployeeRequest;
import com.my.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository; // @Autowired bean ulaşmasını sağlar. Olmazsa nullpointer.

	public List<Employee> getAllEmployeeList() {

		// kontroller yapıldıktan sonra repoya istek atılır.
		return employeeRepository.getAllEmployeeList();
	}

	public Employee getEmployeeById(String id) {
		return employeeRepository.getEmployeeById(id);
	}
	
	public List<Employee> getEmployeeWithParams(String firstName, String lastName){
		return employeeRepository.getEmployeeWithParams(firstName, lastName);
	}
	
	public Employee saveEmployee(Employee newEmployee) {
		return employeeRepository.saveEmployee(newEmployee);
	}
	
	public boolean deleteEmploye(String id) {
		return employeeRepository.deleteEmployee(id);
	}
	
	public Employee updateeEmployee(String id, UpdateEmployeeRequest request) {
		return employeeRepository.updateEmployee(id, request);
	}
}
