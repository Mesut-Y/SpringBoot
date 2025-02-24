package com.my.controller.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.controller.IStudentController;
import com.my.dto.DtoStudentIU;
import com.my.entities.Student;
import com.my.services.IStudentService;
import com.my.dto.DtoStudent;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController{

	@Autowired
	private IStudentService studentService;
	
	//DTO eklenecek.
	@PostMapping(path="/save")
	@Override
	public DtoStudent saveStudent(@RequestBody DtoStudentIU dtoStudentIU) {
		//TODO
		return studentService.saveStudent(dtoStudentIU);
	}

	@GetMapping(path="/list")
	@Override
	public List<DtoStudent> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@GetMapping(path = "/list/{id}")
	@Override
	public Student getStudentById(@PathVariable(name = "id") Integer id)
	{
		return studentService.getStudentById(id);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	@Override
	public void deleteStudent(@PathVariable(name="id") Integer id)
	{
		studentService.deleteStudent(id);
	}
	
	@PutMapping(path="/update/{id}")
	@Override
	public Student updateStudent(@PathVariable(name="id") Integer id,@RequestBody Student updatedStudent)
	{
		return studentService.updateStudent(id, updatedStudent);
	}
	
}
