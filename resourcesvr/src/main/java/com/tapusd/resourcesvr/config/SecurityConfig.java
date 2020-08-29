package com.tapusd.resourcesvr.config;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // @Bean
    // public JwtAccessTokenConverter getAccessTokenConverter(){
    //     JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
    //     converter.setSigningKey("SomeRandomKey1");
    //     converter.setVerifierKey("SomeRandomKey1");
    //     return converter;
    // }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

       
    
}