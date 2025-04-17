package com.my.service;

import com.my.dto.DtoEmployee;

public interface IEmployeeService {

	public DtoEmployee findEmployeeById(Long id);
}
