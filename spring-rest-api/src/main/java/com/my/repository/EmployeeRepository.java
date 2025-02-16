package com.my.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.model.Employee;
import com.my.model.UpdateEmployeeRequest;

@Repository
public class EmployeeRepository {

	@Autowired
	private List<Employee> employeeList;

	public List<Employee> getAllEmployeeList() {

		return employeeList;
	}

	public Employee getEmployeeById(String id) {
		Employee findEmployee = null;
		for (Employee employee : employeeList) {
			if (id.equals(employee.getId())) {
				findEmployee = employee;
				break;
			}
		}
		return findEmployee;
	}
	
	public List<Employee> getEmployeeWithParams(String firstName, String lastName){
		List<Employee> employeeWithParams = new ArrayList<>();
		if (firstName == null && lastName == null)
			return employeeList;
		
		for (Employee employee : employeeList) {
			if (firstName!=null && lastName!=null) {
				if(employee.getFirstName().equalsIgnoreCase(firstName) && employee.getLastName().equalsIgnoreCase(lastName)) {
					employeeWithParams.add(employee);
				}
			}
			if(firstName!=null && lastName==null) {
				if(employee.getFirstName().equalsIgnoreCase(firstName)) {
					employeeWithParams.add(employee);
				}
			}
			if(firstName==null && lastName!=null) {
				if(employee.getLastName().equalsIgnoreCase(lastName)) {
					employeeWithParams.add(employee);
				}
			}
		}
		return employeeWithParams;
	}
	public EmployeeRepository() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee saveEmployee(Employee newEmployee) {
		employeeList.add(newEmployee);
		return newEmployee;
	}
	
	public boolean deleteEmployee(String id) {
		Employee findEmployee = null;
		for (Employee employe:employeeList) {
			if (employe.getId().equalsIgnoreCase(id)) {
				findEmployee = employe;
			}
		}
		if(findEmployee != null) {
			employeeList.remove(findEmployee);
			return true;
		}
		return false;
	}
	
	private Employee findEmployeeById(String id) {
		Employee foundEmployee = null;
		for (Employee employee: employeeList) {
			if (employee.getId().equals(id)) {
				foundEmployee = employee;
				break;
			}
		}
		return foundEmployee;
	}
	
	
	public Employee updateEmployee(String id, UpdateEmployeeRequest request) {
		Employee foundEmployee = findEmployeeById(id);
		if (foundEmployee != null) {
			deleteEmployee(id);
			
			
			/*foundEmployee.setId(id);  versiyon 2
			foundEmployee.setFirstName(request.getFirstName());
			foundEmployee.setLastName(request.getLastName());
			employeeList.add(foundEmployee);*/
			return foundEmployee;
		}
		return null;
	}
}
