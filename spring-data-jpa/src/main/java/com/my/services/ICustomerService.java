package com.my.services;

import com.my.dto.DtoCustomer;

public interface ICustomerService {
	
	public DtoCustomer findCustomerById(Integer id);
}
