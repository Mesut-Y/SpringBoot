package com.my.entities;

import java.util.Locale.IsoCountryCode;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="student")
@Data  //getter and setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="first_name",nullable = false, length = 50)  //boş bırakılamaz ve veri en fazla 50 karakter(default 255)
	private String firstName;
	
	@Column(name="last_name",nullable = false)
	private String lastName;
	
	//@JsonFormat(pattern = "yyy-MM-dd")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name="birth_of_date",nullable = true)
	private String birthOfDate;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "tc_kimlik_no")
	private String tckno;

}
