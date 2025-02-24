package com.my.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU { //Insert ve Update işlemleri
	
	@NotEmpty(message = "Lütfen isim giriniz.")
	@Min(value = 3)
	@Max(value = 20)
	private String firstName;
	
	@Size(min = 3, max = 20)
	private String lastName;
	private String birthOfDate;
	
	@Email(message = "Email formatında bir adres giriniz.")
	private String email;
	
	@Size(min = 11, max = 11, message = "TC Kimlik bilgisini 11 hane giriniz.")
	private String tckn;
}
