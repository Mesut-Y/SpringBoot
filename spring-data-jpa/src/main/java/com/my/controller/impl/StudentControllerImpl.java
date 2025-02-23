package com.my.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping(path="/list")
	@Override
	public List<Student> getAllStudents() {
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
	
}
