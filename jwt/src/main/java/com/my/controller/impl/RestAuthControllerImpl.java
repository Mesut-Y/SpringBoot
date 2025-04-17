package com.my.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.controller.IRestAuthController;
import com.my.dto.DtoUser;
import com.my.jwt.AuthResponse;
import com.my.service.IAuthService;
import com.my.service.impl.AuthServiceImpl;

import jakarta.validation.Valid;

@RestController
public class RestAuthControllerImpl implements IRestAuthController{

	@Autowired
	private IAuthService authService;
	
	@RequestMapping("/register")
	@Override
	public DtoUser register(@Valid @RequestBody DtoUser request) {
		return authService.register(request);
	}

	@PostMapping("/authenticate")
	@Override
	public AuthResponse authenticate(@RequestBody DtoUser request) {
		return authService.authenticate(request);
	}
}
