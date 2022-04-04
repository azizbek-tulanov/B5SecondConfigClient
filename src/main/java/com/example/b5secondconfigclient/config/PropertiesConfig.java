package com.example.b5secondconfigclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class PropertiesConfig {

    @Bean
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }

}
