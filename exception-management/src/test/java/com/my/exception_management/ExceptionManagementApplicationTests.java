package com.my.exception_management;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.my.dto.DtoEmployee;
import com.my.service.IEmployeeService;
import com.my.starter.ExceptionManagementStarter;

@SpringBootTest(classes = {ExceptionManagementStarter.class})
class ExceptionManagementApplicationTests {
	
	@Autowired
	private IEmployeeService employeeService;
	
	@Test
	public void testGetEmployeeById() {
		DtoEmployee dtoEmployee =  employeeService.getEmployeeById(3L);
		if(dtoEmployee!=null){
			System.out.println("isim: " + dtoEmployee.getName());
		}
	}

}
