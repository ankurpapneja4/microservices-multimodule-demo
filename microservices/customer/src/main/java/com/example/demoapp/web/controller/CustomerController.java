package com.example.demoapp.web.controller;

import com.example.demoapp.services.CustomerService;
import com.example.demoapp.web.model.CustomerDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController( CustomerService customerService ){
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable("customerId") UUID customerId){
        return ResponseEntity.ok( customerService.getCustomerById(customerId) );
    }

    @PostMapping
    public ResponseEntity saveNewCustomer( @RequestBody CustomerDTO customerDTO ){

        UUID customerId = customerService.saveNewCustomer( customerDTO );

        HttpHeaders headers = new HttpHeaders();
                    headers.add("location","/api/v1/customer/" + customerId );

        return  new ResponseEntity( headers, HttpStatus.CREATED );

    }
}
