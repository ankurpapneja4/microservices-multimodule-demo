package com.example.demoapp.web.client;

import com.example.demoapp.ClientsApplication;
import com.example.demoapp.web.model.BeerDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest(classes={ ClientsApplication.class })
class BeerServiceClientTest {

    @Autowired
    BeerServiceClient beerServiceClient;

    @Test
    void getBeerById() {

        BeerDTO beerDTO = beerServiceClient.getBeerById(UUID.randomUUID() );

        Assertions.assertNotNull( beerDTO );
    }
}