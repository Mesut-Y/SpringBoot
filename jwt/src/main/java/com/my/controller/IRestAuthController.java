package com.my.controller;

import com.my.dto.DtoUser;
import com.my.jwt.AuthResponse;

public interface IRestAuthController {

	public DtoUser register(DtoUser request);
	
	public AuthResponse authenticate(DtoUser request);
}
