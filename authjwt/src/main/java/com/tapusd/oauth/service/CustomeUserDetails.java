package com.tapusd.oauth.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import com.tapusd.oauth.document.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomeUserDetails implements UserDetails {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    private User user;

    CustomeUserDetails(User user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(user.getRoles().split(",")).stream().map(role-> new SimpleGrantedAuthority("ROLE_"+role))
                    .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.isActive();
    }
    
}