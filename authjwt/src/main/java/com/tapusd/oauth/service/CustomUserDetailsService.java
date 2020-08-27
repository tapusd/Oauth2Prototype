package com.tapusd.oauth.service;

import java.util.Optional;

import com.tapusd.oauth.document.User;
import com.tapusd.oauth.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user =  repo.findByUsername(username);
        user.orElseThrow(()-> new UsernameNotFoundException("Username not found"));
        return user.map(CustomeUserDetails::new).get();

    }
    
}