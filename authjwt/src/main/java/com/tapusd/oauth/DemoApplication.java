package com.tapusd.oauth;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.tapusd.oauth.document.Client;
import com.tapusd.oauth.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
@EnableDiscoveryClient
public class DemoApplication implements CommandLineRunner{

	@Autowired
	ClientRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Optional<Client> client = repo.findByClientId("oauthclient");

		Set<String> set = null;

		if(client.isPresent()){

			set = Arrays.asList(client.get().getAuthorizeGrantTypes().split(",")).stream().collect(Collectors.toSet());
			System.out.println("CLint name is: " + client.get().getAuthorizeGrantTypes());
			System.out.println("authorities::::" + set);
		}
	}

}
