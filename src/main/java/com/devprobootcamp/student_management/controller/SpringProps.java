package com.devprobootcamp.student_management.controller;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("spring.datasource")
public class SpringProps {
    private String url;
    private String username;
    private String password;
    private String driverClassName;
}

