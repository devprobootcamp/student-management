package com.devprobootcamp.student_management.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
public class LoggingInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(
            HttpRequest req, byte[] reqBody, ClientHttpRequestExecution ex) throws IOException {
        log.info("Request body: {}", new String(reqBody, StandardCharsets.UTF_8));
        log.info(req.getURI().getQuery());
        ClientHttpResponse response = ex.execute(req, reqBody);

        return response;
    }
}

