package com.my.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.entities.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

}
