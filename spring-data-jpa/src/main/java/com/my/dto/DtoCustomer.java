package com.my.dto;

import com.my.entities.Address;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoCustomer {
	
	private Integer id;
	
	private String name;
	
	private DtoAddress address;

}
