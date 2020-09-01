package com.tapusd.oauth.repository;

import java.util.Optional;

import com.tapusd.oauth.document.Client;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {
    Optional<Client> findByClientId(String clientId);
    
}