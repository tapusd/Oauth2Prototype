package com.tapusd.oauth.config;

import java.util.LinkedHashMap;
import java.util.Map;

import com.tapusd.oauth.service.CustomeUserDetails;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

// @Component
public class CustomTokenEnhancher extends JwtAccessTokenConverter {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
    
        CustomeUserDetails user = (CustomeUserDetails) authentication.getPrincipal();

        Map<String, Object> info = new LinkedHashMap<>();

        if(user.getUsername() != null){
            info.put("name", user.getUsername());
        }

        DefaultOAuth2AccessToken customeAccessToken = new DefaultOAuth2AccessToken(accessToken);
        customeAccessToken.setAdditionalInformation(accessToken.getAdditionalInformation());

        return super.enhance(customeAccessToken, authentication);

    
    }

    
}