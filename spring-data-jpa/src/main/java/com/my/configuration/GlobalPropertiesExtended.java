package com.my.configuration;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component  //Bean
@ConfigurationProperties(prefix = "app")
public class GlobalPropertiesExtended {
	
	private List<Server> servers; //değişken isimleri aynı olduğu için maplendi.
}
