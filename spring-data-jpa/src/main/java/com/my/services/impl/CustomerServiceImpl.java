package com.my.services.impl;

import java.beans.beancontext.BeanContext;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.dto.DtoAddress;
import com.my.dto.DtoCustomer;
import com.my.entities.Address;
import com.my.entities.Customer;
import com.my.repository.CustomerRepository;
import com.my.services.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public DtoCustomer findCustomerById(Integer id) {
		DtoCustomer dtoCustomer = new DtoCustomer();
		DtoAddress dtoAddress = new DtoAddress();

		Optional<Customer> opt = customerRepository.findById(id);
		if (opt.isEmpty())
			return null;
		else {
			Customer customer = opt.get();
			Address address = opt.get().getAddress();
			BeanUtils.copyProperties(customer, dtoCustomer);
			BeanUtils.copyProperties(address, dtoAddress);
			dtoCustomer.setAddress(dtoAddress);
			return dtoCustomer;
		}
	}

}
