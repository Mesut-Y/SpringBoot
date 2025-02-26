package com.my.services;

import java.util.List;

import com.my.dto.DtoEmployee;
import com.my.entities.Employee;

public interface IEmployeeService {

	public List<DtoEmployee> findAllEmployees();
}
