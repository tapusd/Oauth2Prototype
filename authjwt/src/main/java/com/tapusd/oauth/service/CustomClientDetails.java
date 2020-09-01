package com.tapusd.oauth.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.tapusd.oauth.document.Client;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

public class CustomClientDetails implements ClientDetails {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Client client;
    public CustomClientDetails(Client client){
        this.client = client;
    }

    @Override
    public String getClientId() {
        return client.getClientId();
    }

    @Override
    public Set<String> getResourceIds() {
        return null;
    }

    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public String getClientSecret() {
        return client.getClientSecret();
    }

    @Override
    public boolean isScoped() {
        return true;
    }

    @Override
    public Set<String> getScope() {
        return Arrays.asList(client.getScopes().split(",")).stream().collect(Collectors.toSet());
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return Arrays.asList(client.getAuthorizeGrantTypes().split(",")).stream().collect(Collectors.toSet());
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return null;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        //This role is same as user role and will validate SEPL expressing
        // at method level security
        // so defining a void role so that server can't do anything with role
        // server can only act with it's scopes
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_VOID"));
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return client.getAccessTokenValidityInSeconds();
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return client.getRefreshTokenValidityInSeconds();
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return false;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }
    
}