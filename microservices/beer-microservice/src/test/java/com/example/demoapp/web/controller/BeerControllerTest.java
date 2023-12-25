package com.example.demoapp.web.controller;

import com.example.demoapp.web.model.BeerDTO;
import com.example.demoapp.web.model.BeerStyleEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {

        mockMvc.perform( get("/api/v1/beer/"+ UUID.randomUUID() )
                            .accept(MediaType.APPLICATION_JSON) )
                .andExpect( status().isOk() );

    }

    @Test
    void saveNewBeer() throws Exception {

        BeerDTO beerDTO = getValidBeerDTO();

        String beerDTOJsonString = objectMapper.writeValueAsString( beerDTO );

        mockMvc.perform( post("/api/v1/beer/")
                            .contentType( MediaType.APPLICATION_JSON )
                            .content( beerDTOJsonString ) )
                .andExpect( status().isCreated() );
    }

    @Test
    void updateBeer() throws Exception {

        BeerDTO beerDTO = getValidBeerDTO();

        String beerDTOJsonString = objectMapper.writeValueAsString( beerDTO );

        mockMvc.perform( put("/api/v1/beer/"+UUID.randomUUID().toString())
                            .contentType(MediaType.APPLICATION_JSON)
                            .content( beerDTOJsonString))
                .andExpect( status().isNoContent() );
    }

    BeerDTO getValidBeerDTO(){
        return BeerDTO.builder()
                    .beerName("My Beer")
                    .beerStyle(BeerStyleEnum.ALE)
                    .price(new BigDecimal("2.99"))
                    .upc("123123123123")
                .build();
    }
}