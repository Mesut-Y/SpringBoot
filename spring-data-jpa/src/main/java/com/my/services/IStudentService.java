package com.my.services;

import java.util.List;

import com.my.dto.DtoStudentIU;
import com.my.dto.DtoStudent;
import com.my.entities.Student;

public interface IStudentService {
	
	public DtoStudent saveStudent(DtoStudentIU student);
	
	public List<Student> getAllStudents();
	
	public Student getStudentById(Integer id);
	
	public void deleteStudent(Integer id);
	
	public Student updateStudent(Integer id, Student updatedStudent);
}
