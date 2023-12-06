package com.example.demoapp.web.client;

import com.example.demoapp.domain.configurationproperties.BeerServiceConfigurationProperties;
import com.example.demoapp.web.model.BeerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
@Slf4j
public final class BeerServiceClient {

    private final BeerServiceConfigurationProperties beerServiceConfigurationProperties;
    private final RestTemplate restTemplate;

    public BeerServiceClient(BeerServiceConfigurationProperties properties, RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
        this.beerServiceConfigurationProperties = properties;
    }

    public BeerDTO getBeerById(UUID beerId){

        return restTemplate.getForObject( apihost + V1_BEER_PATH + beerId , BeerDTO.class );
    }
}
