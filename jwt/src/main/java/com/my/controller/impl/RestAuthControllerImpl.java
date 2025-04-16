package com.my.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.controller.IRestAuthController;
import com.my.dto.DtoUser;
import com.my.service.IAuthService;
import com.my.service.impl.AuthServiceImpl;

import jakarta.validation.Valid;

@Controller
public class RestAuthControllerImpl implements IRestAuthController{

	@Autowired
	private IAuthService authService;
	
	@RequestMapping("/register/")
	@Override
	public DtoUser register(@Valid @RequestBody DtoUser request) {
		return authService.register(request);
	}
}
