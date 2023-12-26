package com.example.demoapp.services;

import com.example.demoapp.web.model.BeerDTO;

import java.util.UUID;

public interface BeerService {

    BeerDTO getById(UUID beerId);

    BeerDTO saveNewBeer( BeerDTO beerDTO );

    BeerDTO updateBeer( UUID beerId , BeerDTO beerDTO);

}
