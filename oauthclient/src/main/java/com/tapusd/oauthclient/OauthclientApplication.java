package com.tapusd.oauthclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@SpringBootApplication
@EnableOAuth2Client
@EnableFeignClients
@EnableDiscoveryClient
public class OauthclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthclientApplication.class, args);
	}

}
