package com.example.demoapp.web.client;

import com.example.demoapp.web.model.BeerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
@Slf4j
@ConfigurationProperties("microservices.beer-microservice.config")
public class BeerServiceClient {

    private String apihost;
    private final RestTemplate restTemplate;

    private final String V1_BEER_PATH = "/api/v1/beer/";

    public BeerServiceClient(RestTemplateBuilder restTemplateBuilder){
        restTemplate = restTemplateBuilder.build();
    }

    public BeerDTO getBeerById(UUID beerId){

        return restTemplate.getForObject( apihost + V1_BEER_PATH + beerId , BeerDTO.class );
    }
}
