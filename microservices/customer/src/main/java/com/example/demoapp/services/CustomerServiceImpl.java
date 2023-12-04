package com.example.demoapp.services;

import com.example.demoapp.mappers.CustomerDTOMapper;
import com.example.demoapp.model.Customer;
import com.example.demoapp.web.model.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDTO getCustomerById(UUID customerId) {
        // Mock Implementation
        return CustomerDTOMapper.INSTANCE.customerToCustomerDto(
                    Customer.builder()
                            .id(customerId)
                            .firstName("mary")
                            .lastName("jane")
                            .email("mary.jane@example.com")
                            .build()
                );
    }

    @Override
    public UUID saveNewCustomer(CustomerDTO customerDTO) {

        // Get Customer
        Customer customer = CustomerDTOMapper.INSTANCE.customerDtoToCustomer( customerDTO );

        // Save Customer - Mock Implementation
        customer.setId( UUID.randomUUID() );

        // Return Customer Id
        return customer.getId();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDTO customerDTO) {
            log.debug( "Updating Customer" );
    }

    @Override
    public void deleteCustomer(UUID customerID) {
            log.debug( "Deleting Customer" );
    }


}
