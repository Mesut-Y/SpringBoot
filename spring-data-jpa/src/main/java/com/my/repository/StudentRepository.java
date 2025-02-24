package com.my.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.my.dto.DtoStudent;
import com.my.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	
	@Query(value  = "from Student", nativeQuery = false) // HQL:Hibernate Query Language olduğu için Class ismi ve değişken isimleri kullanılır.
	List<Student> getAllStudentsWithHql();
	
	@Query(value = "SELECT * FROM student.student", nativeQuery = true) //SQL: Structured Query Language
	List<Student> getAllStudentsWithSql();
	
	@Query(value = "from Student s WHERE s.id= :studentId")
	Optional<Student> findStudentById(Integer studentId);
}
