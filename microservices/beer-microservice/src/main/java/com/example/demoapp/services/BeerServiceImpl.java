package com.example.demoapp.services;

import com.example.demoapp.domain.model.Beer;
import com.example.demoapp.mappers.BeerMapper;
import com.example.demoapp.repositories.BeerRepository;
import com.example.demoapp.web.exception.NotFoundException;
import com.example.demoapp.web.model.BeerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService{

    private final BeerRepository beerRepository;

    private final BeerMapper beerMapper;

    @Override
    public BeerDTO getById(UUID beerId) {

        Beer beer = beerRepository
                        .findById( beerId )
                            .orElseThrow( NotFoundException::new );

        return beerMapper.toBeerDTO( beer );
    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO beerDTO) {

        Beer beer = beerMapper.toBeer( beerDTO );

        beerRepository.save( beer );

        return beerMapper.toBeerDTO( beer );
    }

    @Override
    public BeerDTO updateBeer(UUID beerId, BeerDTO beerDTO) {

        Beer beer = beerRepository
                        .findById( beerId )
                            .orElseThrow( NotFoundException::new);

        beer.setBeerName( beerDTO.getBeerName() );
        beer.setBeerStyle( beerDTO.getBeerStyle().name() );
        beer.setPrice( beerDTO.getPrice() );
        beer.setUpc( beerDTO.getUpc() );



        return beerMapper.toBeerDTO(
                            beerRepository.save( beer ));
    }
}
