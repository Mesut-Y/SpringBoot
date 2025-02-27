package com.my.controller.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.configuration.DataSource;
import com.my.configuration.GlobalProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("rest/api/property")
public class PropertySourceController {

	@Autowired
	private GlobalProperties globalProperties;
	
	@GetMapping("/datasource")
	public DataSource getDataSource() {
		DataSource dataSource = new DataSource();
		dataSource.setUrl(globalProperties.getUrl());
		dataSource.setPassword(globalProperties.getPassword());
		dataSource.setUserName(globalProperties.getUserName());
		return dataSource;
	}
	
}
