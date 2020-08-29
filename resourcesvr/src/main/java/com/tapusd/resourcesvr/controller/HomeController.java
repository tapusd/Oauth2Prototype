package com.tapusd.resourcesvr.controller;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
   
    // @GetMapping("/")
    // public String home(){
    //     return "Welcome Home!";
    // }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String user(){
        return "Welcome User!";
    }

    @GetMapping("/admin")
    @PreAuthorize("#oauth2.hasScope('server') or hasRole('USER')")
    public String admin(){
        return "Welcome Admin";
    }


    @GetMapping("/me")
    @PreAuthorize("#oauth2.hasScope('server') or hasRole('ADMIN')")
    public Principal user(Principal principal){
        return principal;
    }
}