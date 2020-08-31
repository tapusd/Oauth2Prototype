package com.tapusd.oauthclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableOAuth2Client
@EnableFeignClients
@EnableDiscoveryClient
public class OauthclientApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OauthclientApplication.class, args);
	}

	@Bean
	@ConfigurationProperties("security.oauth2.client")
	protected ClientCredentialsResourceDetails oAuthDetails() {
		return new ClientCredentialsResourceDetails();
	}

	@Bean
	protected RestTemplate restTemplate() {
		return new OAuth2RestTemplate(oAuthDetails());
	}

	@Override
	public void run(String... args) throws Exception {
		String url = "http://localhost:8081/user";
		String result = restTemplate().getForObject(url, String.class);
		System.out.println("RESULT IS::: "+ result);

	}

}
