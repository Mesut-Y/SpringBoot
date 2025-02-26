package com.my.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.dto.DtoDepartment;
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
		if (!dbEmployeesList.isEmpty() && dbEmployeesList != null)
		{
			for(Employee employee: dbEmployeesList)
			{
				DtoEmployee dtoEmployee = new DtoEmployee(); //liste ekleme için yeni nesne
				BeanUtils.copyProperties(employee, dtoEmployee);
				//dtoEmployee.setId(employee.getId());
				//dtoEmployee.setName(employee.getName());
				dtoEmployee.setDepartment(new DtoDepartment(employee.getDepartment().getId(), 
						                                    employee.getDepartment().getDepartmentName()));
				dtoEmployeeList.add(dtoEmployee);
			}
			return dtoEmployeeList;
		}
		return null;
	}
	
}
