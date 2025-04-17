package com.my.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.my.dto.DtoUser;
import com.my.jwt.AuthResponse;
import com.my.jwt.JwtService;
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
	
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Autowired
	private JwtService jwtService;
	
	@Override
	public AuthResponse authenticate(DtoUser request) {
		try {
			UsernamePasswordAuthenticationToken auth = 
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
			authenticationProvider.authenticate(auth);
			Optional<User> opt = userRepository.findByUsername(request.getUsername());
			String token = jwtService.generateToken(opt.get());
			return new AuthResponse(token);
		} catch (Exception e) {
			//exception
			System.out.println("Kullanıcı adı veya şifre hatalıdır.");
		}
		return null;
	}
	
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
