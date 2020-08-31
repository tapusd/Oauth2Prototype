package com.tapusd.oauth.config;

import com.tapusd.oauth.service.CustomUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class Oauth2Config extends AuthorizationServerConfigurerAdapter {

    // private TokenStore tokenStore = new InMemoryTokenStore();

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("roko")
                .secret("secret")
                .scopes("browser")
                .authorizedGrantTypes("password", "refresh_token")
                .accessTokenValiditySeconds(3600)
                .refreshTokenValiditySeconds(18000)
                .authorities("USER")
                .and()
                .withClient("rokobo")
                .secret("secret1")
                .scopes("read","write")
                .authorizedGrantTypes("password")
                .accessTokenValiditySeconds(60)
                .refreshTokenValiditySeconds(5000)
                .authorities("ADMIN")
                .and()
                .withClient("oauthclient")
                .secret("secret")
                .scopes("server")
                .authorizedGrantTypes("client_credentials","refresh_token")
                .accessTokenValiditySeconds(3600)
                .refreshTokenValiditySeconds(5000)
                .and()
                .withClient("resourceserver")
                .secret("secret")
                .scopes("server")
                .authorizedGrantTypes("client_credentials","refresh_token")
                .accessTokenValiditySeconds(3600)
                .refreshTokenValiditySeconds(5000);
                
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore())
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService)
                .accessTokenConverter(getAccessTokenConverter());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

   @Bean
   public AccessTokenConverter getAccessTokenConverter(){
       JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
       converter.setSigningKey("KdklKDMfkLKfjeilakdxLKSDJfielKDJfyi");
       return converter;
   } 

   @Bean
   public JwtTokenStore tokenStore(){
       return new JwtTokenStore(new CustomTokenEnhancher());
   } 
    
    
}