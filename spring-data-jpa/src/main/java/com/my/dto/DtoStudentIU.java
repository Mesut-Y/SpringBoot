package com.my.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU { //Insert ve Update işlemleri
	
	@NotEmpty(message = "Lütfen isim giriniz.")
	private String firstName;
	private String lastName;
	private String birthOfDate;
}
