package com.my.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.controller.IStudentController;
import com.my.entities.Student;
import com.my.services.IStudentService;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController{

	@Autowired
	private IStudentService studentService;
	
	//DTO eklenecek.
	@PostMapping(path="/save")
	@Override
	public Student saveStudent(@RequestBody Student student) {
		//TODO
		return studentService.saveStudent(student);
	}
	
}
