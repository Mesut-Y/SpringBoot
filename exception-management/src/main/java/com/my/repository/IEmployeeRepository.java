package com.my.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.entities.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

}
