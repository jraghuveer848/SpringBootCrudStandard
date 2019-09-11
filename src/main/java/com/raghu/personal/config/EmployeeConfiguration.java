package com.raghu.personal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource("classpath:config.properties")
public class EmployeeConfiguration {

	@Autowired
	Environment env;
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
