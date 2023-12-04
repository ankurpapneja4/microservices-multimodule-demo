package com.example.demoapp.web.controller;

import com.example.demoapp.services.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vi/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController( CustomerService customerService ){
        this.customerService = customerService;
    }

}
