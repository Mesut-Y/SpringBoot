package com.my.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.my.entities.Address;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)  //null olmayanları json gösterir.
public class DtoCustomer {
	
	private Integer id;
	
	private String name;
	
	private DtoAddress address;

}
