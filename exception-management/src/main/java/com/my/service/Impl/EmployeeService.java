package com.my.service.Impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.dto.DtoDepartment;
import com.my.dto.DtoEmployee;
import com.my.entities.Employee;
import com.my.repository.IEmployeeRepository;
import com.my.service.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService{

	@Autowired
	private IEmployeeRepository employeeRepository;
	
	@Override
	public List<DtoEmployee> getAllEmployees()
	{
		List<DtoEmployee> listOfEmployees = new ArrayList<>();
		List<Employee> dbEmployees = employeeRepository.findAll();
		if (dbEmployees.isEmpty() || dbEmployees == null)
		{
			return null;
		}
		else {
			for(Employee employee : dbEmployees)
			{
				DtoEmployee dtoEmployee = new DtoEmployee();
				BeanUtils.copyProperties(employee, dtoEmployee);
				dtoEmployee.setDtoDepartment(new DtoDepartment(employee.getDepartment().getId(), employee.getDepartment().getName()));
				listOfEmployees.add(dtoEmployee);
			}
			return listOfEmployees;
		}
		 
	}
}
