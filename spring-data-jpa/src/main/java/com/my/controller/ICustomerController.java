package com.my.controller;

import com.my.dto.DtoCustomer;

public interface ICustomerController {
	
	public DtoCustomer findCustomerById(Integer id);
}
