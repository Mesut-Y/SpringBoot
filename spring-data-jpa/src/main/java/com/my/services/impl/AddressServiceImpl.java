package com.my.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.dto.DtoAddress;
import com.my.dto.DtoCustomer;
import com.my.entities.Address;
import com.my.entities.Customer;
import com.my.repository.AddressRepository;
import com.my.services.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService{

	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public DtoAddress getAddressById(Integer id) {
		DtoAddress dtoAddress = new DtoAddress();
		DtoCustomer dtoCustomer = new DtoCustomer();
		
		Optional<Address> opt = addressRepository.findById(id);
		if (opt.isEmpty())
			return null;
		else {
			Address address = opt.get();
			Customer customer = opt.get().getCustomer();
			
			BeanUtils.copyProperties(address, dtoAddress);
			BeanUtils.copyProperties(customer, dtoCustomer);
			dtoAddress.setDtoCustomer(dtoCustomer);
			
			return dtoAddress;
		}
	}

}
