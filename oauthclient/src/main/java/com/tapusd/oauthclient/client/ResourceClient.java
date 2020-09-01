package com.tapusd.oauthclient.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("resourceserver")
public interface ResourceClient {
    @GetMapping("/admin")
    public String callAdmin();

    @GetMapping("/user")
    public String callUser();
}