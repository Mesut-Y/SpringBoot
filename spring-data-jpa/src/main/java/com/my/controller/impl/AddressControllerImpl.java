package com.my.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.controller.IAddressController;
import com.my.dto.DtoAddress;
import com.my.services.IAddressService;

@RestController
@RequestMapping("/rest/api/address")
public class AddressControllerImpl implements IAddressController{

	@Autowired
	public IAddressService addressService;
	
	@GetMapping(path = "/list/{id}")
	@Override
	public DtoAddress getAdressById(@PathVariable(name = "id") Integer id) {
		return addressService.getAddressById(id);
	}

}
