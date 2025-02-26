package com.my.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.dto.DtoEmployee;
import com.my.entities.Employee;
import com.my.repository.EmployeeRepository;
import com.my.services.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<DtoEmployee> findAllEmployees() {
		List<DtoEmployee> dtoEmployeeList =new ArrayList<>(); //verileri return yapmak için
		List<Employee> dbEmployeesList = employeeRepository.findAll();
		if (!dbEmployeesList.isEmpty() || dbEmployeesList != null)
		{
			BeanUtils.copyProperties(dbEmployeesList, dtoEmployeeList);
//			for(Employee employee: dbEmployeesList)
//			{
//				dto
//			}
			return dtoEmployeeList;
		}
		return null;
	}
	
}
