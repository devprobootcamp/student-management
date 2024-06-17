package com.devprobootcamp.student_management.controller;

import com.devprobootcamp.student_management.dto.CountryNameDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AppController {

    @Value("${app.name}")
    private String appName;

    @Value("${app.setting}")
    private String appSetting;

    @Value("${spring.application.name}")
    private String springAppName;

    @Autowired
    private AppProps appProps;

    @Autowired
    private Environment env;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/app")
    public ResponseEntity<String> handle() {
        return ResponseEntity.ok("Hello: " + appName + ", " + springAppName + "," + appSetting + ", " + appProps.getActive());
    }


    @GetMapping("/app2")
    public ResponseEntity<String> handle2() {
        return ResponseEntity.ok("Hello: " + appProps.getName() + ", " + appProps.getSetting());
    }

    @GetMapping("/app3")
    public ResponseEntity<String> handle3() {
        return ResponseEntity.ok(env.getProperty("spring.datasource.username"));
    }

    @GetMapping("/app4")
    public ResponseEntity<List<CountryNameDTO>> handle4(@RequestParam String name) {
        CountryNameDTO[] forObject = restTemplate.getForObject(appProps.getCountryUrl() + "/" + name, CountryNameDTO[].class);
        return ResponseEntity.ok(Arrays.asList(forObject));
    }

    @GetMapping("/app5")
    public ResponseEntity<String> handle5() {
        String forObject = restTemplate.getForObject("https://restcountries.com/v3.1/name/cameroon", String.class);
        return ResponseEntity.ok(forObject);
    }
}
