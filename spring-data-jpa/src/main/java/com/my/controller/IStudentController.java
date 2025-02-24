package com.my.controller;

import java.util.List;

import com.my.dto.DtoStudent;
import com.my.dto.DtoStudentIU;
import com.my.entities.Student;

public interface IStudentController {
	
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);
	
	public List<DtoStudent> getAllStudents();
	
	public DtoStudent getStudentById(Integer id);
	
	public void deleteStudent(Integer id);
	
	public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU);
}
