package com.example.demoapp.web.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
@ConfigurationProperties("microservices.beer-microservice.config")
public class BeerServiceClient {

    private String apihost;
    private final RestTemplate restTemplate;

    public BeerServiceClient(RestTemplateBuilder restTemplateBuilder){
        restTemplate = restTemplateBuilder.build();
    }
}
