package com.my.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.entities.Student;
import com.my.repository.StudentRepository;
import com.my.services.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
		
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

}
