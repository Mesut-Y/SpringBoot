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
	public DtoStudent getStudentById(Integer id) {
		Optional<Student> opt = studentRepository.findById(id);
		DtoStudent dtoStudent = new DtoStudent();
		if (opt.isPresent()) //  !opt.isEmpty()
		{
			BeanUtils.copyProperties(opt.get(), dtoStudent);
			return dtoStudent;
		}
		return null;
	}
	
	@Override
	public void deleteStudent(Integer id)
	{
		Optional<Student> opt = studentRepository.findById(id);
		if (opt.get() != null)
		{
			studentRepository.delete(opt.get());
		}
		else {
			System.out.println("Servis mesajı kayıt bulunamadı.");
		}
	}
	
	@Override
	public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU)
	{
		Optional<Student> opt = studentRepository.findById(id);
		if (opt.isPresent())
		{
			opt.get().setFirstName(dtoStudentIU.getFirstName());
			opt.get().setLastName(dtoStudentIU.getLastName());
			opt.get().setBirthOfDate(dtoStudentIU.getBirthOfDate());
			
			Student updatedStudent = studentRepository.save(opt.get());
			DtoStudent dto = new DtoStudent();
			BeanUtils.copyProperties(updatedStudent, dto);
			return dto;
		}
		
		return null;
	}

}
