package com.my.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.entities.Home;

@Repository
public interface HomeRepository extends JpaRepository<Home, Integer>{

}
