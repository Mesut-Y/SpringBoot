package com.my.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.dto.DtoStudent;
import com.my.dto.DtoStudentIU;
import com.my.entities.Student;
import com.my.repository.StudentRepository;
import com.my.services.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
		DtoStudent response = new DtoStudent();
		Student student= new Student();
		BeanUtils.copyProperties(dtoStudentIU, student);
		Student dbStudent = studentRepository.save(student);

		BeanUtils.copyProperties(dbStudent,response);
		return response;
	}

	@Override
	public List<DtoStudent> getAllStudents() {
		List<DtoStudent> dtoList = new ArrayList<>();
		List<Student> studentList = studentRepository.findAll();
		for (Student student : studentList)
		{
			DtoStudent dto = new DtoStudent();
			BeanUtils.copyProperties(student, dto);
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public Student getStudentById(Integer id) {
		Optional<Student> opt = studentRepository.findById(id);
		if (opt.isPresent()) //  !opt.isEmpty()
		{
			return opt.get();
		}
		return null;
	}
	
	@Override
	public void deleteStudent(Integer id)
	{
		Student dbStudent = getStudentById(id);
		if (dbStudent!=null)
			studentRepository.delete(dbStudent);
		else {
			System.out.println("Servis mesajı kayıt bulunamadı.");
		}
	}
	
	@Override
	public Student updateStudent(Integer id, Student updatedStudent)
	{
		Student dbStudent = getStudentById(id);
		if (dbStudent != null)
		{
			dbStudent.setFirstName(updatedStudent.getFirstName());
			dbStudent.setLastName(updatedStudent.getLastName());
			dbStudent.setBirthOfDate(updatedStudent.getBirthOfDate());
			dbStudent.setId(id);
			studentRepository.save(dbStudent);
			return dbStudent;
		}
		return null;
	}

}
