package com.tapusd.oauthclient.controller;

import com.tapusd.oauthclient.client.ResourceClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

//    private String baseUrl = "http://localhost:8081";

//    @Autowired
//    private RestTemplate restTemplate;

   @Autowired
   private ResourceClient client;

   @GetMapping("/") 
   public String home(){
       return "This is client home";
   }

   @GetMapping("/resource/user")
   public String resourceUser(){
       String val = client.callUser();
    // String val = restTemplate.getForObject(baseUrl+"/user", String.class);
    // if(val == null){
    //     val = "";
    // }

    return "This is from resource server: " + val;
   }

   @GetMapping("/resource/admin")
   public String resourceAdmin(){
       String val = client.callAdmin();
        // String val =  restTemplate.getForObject(baseUrl+"/admin", String.class);
        // if(val == null){
        //     val = "";
        // }

        System.out.println("THIs is from inside the controller class: returned stirng is::::::::: + "+ val);
        return "From client appended resource value by calling admin: " + val;
   }
}