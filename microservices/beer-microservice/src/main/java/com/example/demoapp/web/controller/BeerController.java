package com.example.demoapp.web.controller;

import com.example.demoapp.services.BeerService;
import com.example.demoapp.web.model.BeerDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
@RequiredArgsConstructor
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDTO> getBeerById(@PathVariable UUID beerId){

        return ResponseEntity.ok(
                    beerService.getById( beerId ));
    }

    @PostMapping("/")
    public ResponseEntity<BeerDTO> saveNewBeer( @Valid @RequestBody BeerDTO beerDTO ){

        return new ResponseEntity<>( beerService.saveNewBeer( beerDTO ), HttpStatus.CREATED );
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDTO> updateBeer( @PathVariable UUID beerId, @Valid @RequestBody BeerDTO beerDTO ){

        return new ResponseEntity<>(
                beerService.updateBeer( beerId, beerDTO), HttpStatus.NO_CONTENT);

    }

    @DeleteMapping("/{beerId}")
    public ResponseEntity deleteBeer( @PathVariable UUID beerId ){

        //Todo - Implementation
        return ResponseEntity.noContent().build();

    }


}

