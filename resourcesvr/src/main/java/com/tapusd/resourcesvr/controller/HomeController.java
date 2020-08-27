package com.tapusd.resourcesvr.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
   
    @GetMapping("/")
    public String home(){
        return "Welcome Home!";
    }
    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String user(){
        return "Welcome User!";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin(){
        return "Welcome Admin";
    }
}