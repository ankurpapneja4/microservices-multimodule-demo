package com.example.demoapp.services;

import com.example.demoapp.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {

    CustomerDTO getCustomerById( UUID customerId );

}
