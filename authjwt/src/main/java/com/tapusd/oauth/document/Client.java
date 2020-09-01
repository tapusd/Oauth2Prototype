package com.tapusd.oauth.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "clients")
public class Client {
   @Id
   private String id;
   private String clientId;
   private String clientSecret;
   private String authorizeGrantTypes;
   private String scopes;
   private Integer accessTokenValidityInSeconds;
   private Integer refreshTokenValidityInSeconds;

   public String getId() {
       return id;
   }

   public void setId(String id) {
       this.id = id;
   }

   public String getClientId() {
       return clientId;
   }

   public void setClientId(String clientId) {
       this.clientId = clientId;
   }

   public String getClientSecret() {
       return clientSecret;
   }

   public void setClientSecret(String clientSecret) {
       this.clientSecret = clientSecret;
   }

   public String getAuthorizeGrantTypes() {
       return authorizeGrantTypes;
   }

   public void setAuthorizeGrantTypes(String grantedAuthorities) {
       this.authorizeGrantTypes = grantedAuthorities;
   }

   public String getScopes() {
       return scopes;
   }

   public void setScopes(String scopes) {
       this.scopes = scopes;
   }

   public Integer getAccessTokenValidityInSeconds() {
       return accessTokenValidityInSeconds;
   }

   public void setAccessTokenValidityInSeconds(Integer accessTokenValidityInSeconds) {
       this.accessTokenValidityInSeconds = accessTokenValidityInSeconds;
   }

   public Integer getRefreshTokenValidityInSeconds() {
       return refreshTokenValidityInSeconds;
   }

   public void setRefreshTokenValidityInSeconds(Integer refreshTokenValidityInSeconds) {
       this.refreshTokenValidityInSeconds = refreshTokenValidityInSeconds;
   }


}