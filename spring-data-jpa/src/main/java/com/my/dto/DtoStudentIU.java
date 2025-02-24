package com.my.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU { //Insert ve Update işlemleri
	private String firstName;
	private String lastName;
	private String birthOfDate;
}
