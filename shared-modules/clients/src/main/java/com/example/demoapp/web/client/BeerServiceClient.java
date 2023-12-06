package com.example.demoapp.web.client;

import com.example.demoapp.domain.configurationproperties.BeerServiceConfigurationProperties;
import com.example.demoapp.web.model.BeerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@Slf4j
public final class BeerServiceClient {

    private final BeerServiceConfigurationProperties config;
    private final RestTemplate restTemplate;

    public BeerServiceClient(BeerServiceConfigurationProperties config, RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
        this.config = config;
    }

    public BeerDTO getBeerById(UUID beerId){

        String url = config.absoluteServiceURL() + UUID.randomUUID();

        return  restTemplate.getForObject( url, BeerDTO.class );
    }


    public URI saveNewBeer(BeerDTO beerDTO ){

        String requestURL = config.absoluteServiceURL();

        return restTemplate.postForLocation( requestURL, beerDTO);

    }

}
