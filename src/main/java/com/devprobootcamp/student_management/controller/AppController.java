package com.devprobootcamp.student_management.controller;

import com.devprobootcamp.student_management.dto.CountryNameDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
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
    @Qualifier("rt1")
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("rt2")
    private RestTemplate restTemplate2;

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

//        restTemplate.getForObject(URI.create("https://restcountries.com/v3.1/name/cameroon"), String.class);
//        restTemplate.getForObject("https://restcountries.com/v3.1/name/cameroon", String.class, "name=congo", "city=limbe");
//        HashMap<String, String> urlVariable = new HashMap<>();
//        urlVariable.put("name", "congo");
//        urlVariable.put("city", "limbe");
//        restTemplate.getForObject("https://restcountries.com/v3.1/name/cameroon", String.class, urlVariable);
//
//        restTemplate.postForObject("url", "body", Void.class );
//        restTemplate.getForObject()
        

        return ResponseEntity.ok(forObject);
    }
}
