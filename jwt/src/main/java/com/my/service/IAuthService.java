package com.my.service;

import com.my.dto.DtoUser;
import com.my.jwt.AuthResponse;

public interface IAuthService {

	public DtoUser register(DtoUser request);
	
	public AuthResponse authenticate(DtoUser request);
}
