package com.tapusd.oauthclient.controller;

import com.tapusd.oauthclient.client.AuthClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
   @Autowired
   private AuthClient client;

   @GetMapping("/") 
   public String home(){
       return "This is client home";
   }

   @GetMapping("/resource/user")
   public String resourceUser(){
        String val =  client.callAdmin();
        return "From client appended resource value by calling admin: " + val;
   }
}