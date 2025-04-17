package com.my.service.impl;

import java.awt.JobAttributes.DialogType;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.dto.DtoDepartment;
import com.my.dto.DtoEmployee;
import com.my.model.Employee;
import com.my.repository.EmployeeRepository;
import com.my.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	public EmployeeRepository employeeRepository;
	
	@Override
	public DtoEmployee findEmployeeById(Long id) {
		 Optional<Employee> opt = employeeRepository.findById(id);
		 if(opt.isEmpty()) {
			 //Exception
			 return null;
		 }
		 DtoEmployee dtoEmployee = new DtoEmployee();
		 DtoDepartment dto = new DtoDepartment();
		 
		 BeanUtils.copyProperties(opt.get(), dtoEmployee);
		 BeanUtils.copyProperties(opt.get().getDepartment(), dtoEmployee.getDtoDepartment());
		
		return dtoEmployee;
	}

}
