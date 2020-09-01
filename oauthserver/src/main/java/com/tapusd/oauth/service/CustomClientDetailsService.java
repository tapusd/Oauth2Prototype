package com.tapusd.oauth.service;

import java.util.Optional;

import com.tapusd.oauth.document.Client;
import com.tapusd.oauth.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

@Service
public class CustomClientDetailsService implements ClientDetailsService {
    @Autowired
    ClientRepository repo;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        Optional<Client> client = repo.findByClientId(clientId);
        client.orElseThrow(()-> new ClientRegistrationException("Client not found"));
        return client.map(CustomClientDetails::new).get();
    }
    
}