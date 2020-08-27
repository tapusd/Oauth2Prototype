package com.tapusd.resourcesvr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class ResourcesvrApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourcesvrApplication.class, args);
	}

}
