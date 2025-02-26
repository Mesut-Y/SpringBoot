package com.my.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
