package com.mesuty.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mesuty.config.AppConfig;

public class LoginService {
	public void login() {
		// User listesine ihtiyaç var. maindeki gibi bean çekilir.
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = context.getBean(UserService.class);
	}
}
