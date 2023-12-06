package com.example.demoapp.web.client;

import com.example.demoapp.ClientsApplication;
import com.example.demoapp.web.model.BeerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes={ ClientsApplication.class })
class BeerServiceClientTest {

    @Autowired
    BeerServiceClient beerServiceClient;

    @Test
    void getBeerById() {

        BeerDTO beerDTO = beerServiceClient.getBeerById(UUID.randomUUID() );

        assertNotNull( beerDTO );
    }

    @Test
    void testSaveNewBeer(){

        BeerDTO beerDTO = BeerDTO.builder().beerName("New Beer").build();

        URI uri = beerServiceClient.saveNewBeer(beerDTO);

        assertNotNull( uri );
    }

    @Test
    void testUpdateBeer(){

        BeerDTO beerDTO = BeerDTO.builder().beerName("Updated Name").build();
        beerServiceClient.updateBeer( UUID.randomUUID(), beerDTO);
    }


    @Test
    void testDeleteBeer() {

        beerServiceClient.deleteBeer( UUID.randomUUID() );
    }
}