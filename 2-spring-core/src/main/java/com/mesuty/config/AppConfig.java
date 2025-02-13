package com.mesuty.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mesuty.model.User;
import com.mesuty.services.UserService;

@Configuration
public class AppConfig {

	// REstController, Repository, Service sterotype annotations

	@Bean
	public UserService userService() {
		UserService userService = new UserService();

		List<User> userList = new ArrayList<>();
		userList.add(new User("Mesut"));
		userList.add(new User("Mutlu"));

		userService.setUserList(userList);

		return userService();

	}
}
