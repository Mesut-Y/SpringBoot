package com.my.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.controller.IHomeController;
import com.my.dto.DtoHome;
import com.my.services.IHomeService;

@RestController
@RequestMapping("/rest/api")
public class HomeControllerImpl implements IHomeController{
	
	@Autowired
	public IHomeService homeService;
	
	@GetMapping(path = "/home/{id}")
	@Override
	public DtoHome getHomeById(@PathVariable(name = "id") Integer id) {
		return homeService.getHomeById(id);
	}
}
