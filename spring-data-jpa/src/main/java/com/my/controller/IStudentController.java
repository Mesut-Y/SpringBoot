package com.my.controller;

import java.util.List;

import com.my.entities.Student;

public interface IStudentController {
	
	public Student saveStudent(Student student);
	
	public List<Student> getAllStudents();
}
