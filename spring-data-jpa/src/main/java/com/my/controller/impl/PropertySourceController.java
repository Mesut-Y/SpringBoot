package com.my.controller.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.configuration.DataSource;
import com.my.configuration.GlobalProperties;
import com.my.configuration.GlobalPropertiesExtended;
import com.my.configuration.Server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("rest/api/property")
public class PropertySourceController {

	@Autowired
	private GlobalProperties globalProperties;
	
	@Autowired
	private GlobalPropertiesExtended globalPropertiesExtended;
	
	@GetMapping("/datasource")
	public DataSource getDataSource() {
		DataSource dataSource = new DataSource();
		dataSource.setUrl(globalProperties.getUrl());
		dataSource.setPassword(globalProperties.getPassword());
		dataSource.setUserName(globalProperties.getUserName());
		return dataSource;
	}
	
	@GetMapping("/getservers")
	public List<Server> getServers(){
		return globalPropertiesExtended.getServers();
	}
}
