package com.example.demoapp.web.controller;

import com.example.demoapp.web.model.BeerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDTO> getBeerById(@PathVariable UUID beerId){

        //Todo - implementation
        return ResponseEntity.ok( BeerDTO.builder().build() );
    }

    @PostMapping
    public ResponseEntity saveNewBeer( @RequestBody BeerDTO beerDTO ){

        //Todo - implementation
        return ResponseEntity
                    .created( URI.create( "/api/v1/beer/" + UUID.randomUUID().toString()) )
                    .build();
    }

    @PutMapping("/{beerId}")
    @ResponseStatus( HttpStatus.NO_CONTENT )
    public void updateBeer( @PathVariable UUID beerId, @RequestBody BeerDTO beerDTO ){

        //Todo - Implementation

    }


}

