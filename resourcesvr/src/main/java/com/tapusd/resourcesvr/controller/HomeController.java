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
    @PreAuthorize("hasRole('USER') or #oauth2.hasScope('SERVER')")
    public String user(){
        return "Welcome User!";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin(){
        return "Welcome Admin";
    }


    @GetMapping("/me")
    @PreAuthorize("hasRole('ADMIN') or #oauth2.hasScope('SERVER')")
    public Principal user(Principal principal){
        return principal;
    }
}