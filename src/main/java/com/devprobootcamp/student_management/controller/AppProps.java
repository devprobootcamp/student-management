package com.devprobootcamp.student_management.controller;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties("app")
public class AppProps {
    private String name;
    private String setting;
    private String active;
    private String countryUrl;

}
