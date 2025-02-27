package com.my.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.my.configuration.GlobalPropertiesExtended;

@SpringBootApplication
@EntityScan(basePackages = "com.my") //Tüm projedeki entity araştırması yapılır.
@ComponentScan(basePackages = "com.my")
@EnableJpaRepositories(basePackages = "com.my")   
@PropertySource(value = "classpath:app.properties")
@EnableConfigurationProperties(value = GlobalPropertiesExtended.class)
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

}
