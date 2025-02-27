package com.my.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudent {  //get işlemleri
	
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private List<DtoCourse> courses;
}
