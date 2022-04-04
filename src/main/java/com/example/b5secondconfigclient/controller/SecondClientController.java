package com.example.b5secondconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/api/second")
public class SecondClientController {

    @Value("${secretkey.firstMicroService}")
    private String firstMicroService;

    @Value("${secretkey.secondMicroService}")
    private String secondMicroService;

    @GetMapping
    public HttpEntity<?> get(){
        return ResponseEntity.ok("First : "+firstMicroService+" . Second : "+secondMicroService);
    }

    @GetMapping("/allStudent")
    public Object allStudent(){
        System.out.println("Entered...");
        return true;
    }
}
