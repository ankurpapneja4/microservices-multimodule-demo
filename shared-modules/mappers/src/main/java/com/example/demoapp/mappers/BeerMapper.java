package com.example.demoapp.mappers;

import com.example.demoapp.domain.model.Beer;
import com.example.demoapp.web.model.BeerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper( uses = { DateMapper.class })
public interface BeerMapper {

    BeerMapper INSTANCE = Mappers.getMapper(BeerMapper.class);

    BeerDTO toBeerDTO(Beer beer);

    Beer toBeer(BeerDTO beerDTO);
}
