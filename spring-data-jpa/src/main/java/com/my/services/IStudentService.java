package com.my.services;

import java.util.List;

import com.my.dto.DtoStudentIU;
import com.my.dto.DtoStudent;
import com.my.entities.Student;

public interface IStudentService {
	
	public DtoStudent saveStudent(DtoStudentIU student);
	
	public List<DtoStudent> getAllStudents();
	
	public DtoStudent getStudentById(Integer id);
	
	public void deleteStudent(Integer id);
	
	public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU);
}
