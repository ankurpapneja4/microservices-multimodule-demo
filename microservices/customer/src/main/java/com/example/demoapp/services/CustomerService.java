package com.example.demoapp.services;

import com.example.demoapp.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {

    CustomerDTO getCustomerById( UUID customerId );

    UUID saveNewCustomer( CustomerDTO customerDTO );

    void updateCustomer( UUID customerId, CustomerDTO customerDTO );

}
