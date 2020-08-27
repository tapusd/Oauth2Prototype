package com.tapusd.oauth.repository;

import java.util.Optional;

import com.tapusd.oauth.document.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String>{
    Optional<User> findByUsername(String username);
    
}