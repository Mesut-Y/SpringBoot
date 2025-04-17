package com.my.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.my.dto.DtoUser;
import com.my.model.User;
import com.my.repository.UserRepository;
import com.my.service.IAuthService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class AuthServiceImpl implements IAuthService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public DtoUser register(DtoUser request) {
		DtoUser dtoUser = new DtoUser();
		User user = new User();
		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		User savedUser = userRepository.save(user);

		BeanUtils.copyProperties(savedUser, dtoUser);
		return dtoUser;
	}

}
