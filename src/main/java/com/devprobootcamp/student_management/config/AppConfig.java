package com.devprobootcamp.student_management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
public class AppConfig {

    @Bean(name = "rt1")
    public RestTemplate restTemplate1(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList(new LoggingInterceptor()));
        return restTemplate;
    }

    @Bean(name = "rt2")
    public RestTemplate restTemplate2(){
        return new RestTemplate();
    }


}

