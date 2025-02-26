package com.my.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
