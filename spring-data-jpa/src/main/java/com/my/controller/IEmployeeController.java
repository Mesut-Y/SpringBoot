package com.my.controller;

import java.util.List;

import com.my.dto.DtoEmployee;

public interface IEmployeeController {

	public List<DtoEmployee> findAllEmployees();
}
