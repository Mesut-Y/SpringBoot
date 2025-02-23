package com.my.services;

import java.util.List;

import com.my.entities.Student;

public interface IStudentService {
	
	public Student saveStudent(Student student);
	
	public List<Student> getAllStudents();
	
	public Student getStudentById(Integer id);
}
